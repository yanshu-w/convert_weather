package com.wy.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.wy.domain.vo.MqttParam;
import com.wy.utils.JsonUtil;
import com.wy.utils.NotNullChecker;
import com.wy.utils.PrintErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.stereotype.Component;

import java.io.EOFException;
import java.util.List;
import java.util.Objects;


/**
 * 监听订阅消息接口
 */
@Slf4j
@Component
public class ReceiveMsgCallback implements MqttCallback {


    @Override
    public void connectionLost(Throwable cause) {
        //messageArrived方法抛出异常就会执行当前方法；
        //但只要执行这个方法就会断开连接
        log.error("MQTT连接丢失" + cause.getMessage());
        log.error(PrintErrorUtil.print(cause));

        //此异常为断开连接
        if (cause.getCause() instanceof EOFException) {
            //重连
            reConnect();
        }

    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        try {
            String msg = new String(message.getPayload());
            log.info("接受消息:" + msg);

            MqttParam mqttParam = JsonUtil.JsonToTarget(msg, MqttParam.class);

            if (Objects.isNull(mqttParam)) {
                log.error("没有接收到任何消息");
                return;
            }

            List<String> fieldNames = NotNullChecker.getNullFieldNames(mqttParam);

            if (CollUtil.isEmpty(fieldNames)) {
                //将param存入队列 依次执行
                MqttClientCreator.ParamQueue.add(mqttParam);
            } else {
                log.error(fieldNames + "存在空值，此次请求失败");
            }
        } catch (Throwable t) {
            log.error("处理接受的信息失败");
            log.error(PrintErrorUtil.print(t));
        }


    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("publish Msg success");
    }

    /**
     * 重新连接
     */
    private void reConnect() {
        try {
            if (MqttClientCreator.Reconnect.running()) {
                return;
            }

            MqttClientCreator.Reconnect.start();
            log.error("开始重连");

            MqttClient mqttClient = SpringUtil.getBean("subscribeMqttClient", MqttClient.class);
            MqttConnectOptions options = MqttClientCreator.createOptions("xsjhwy", "xsjhwy123456*");

            Thread.sleep(400L);
            mqttClient.connect(options);
            mqttClient.subscribe("mqtt/cwea_wy_subscribe_topic_3");
            MqttClientCreator.Reconnect.finish();
            log.error("重连成功");
        } catch (Throwable t) {
            log.error(PrintErrorUtil.print(t));
        } finally {
            log.error("重连结束");
        }

    }
}
