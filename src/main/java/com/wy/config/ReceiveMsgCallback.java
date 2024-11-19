package com.wy.config;

import cn.hutool.core.collection.CollUtil;
import com.wy.domain.vo.MqttParam;
import com.wy.utils.JsonUtil;
import com.wy.utils.NotNullChecker;
import com.wy.utils.PrintErrorUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

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
        log.error("MQTT连接丢失" + cause.getMessage());
        log.error(PrintErrorUtil.print(cause));
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
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


    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("publish Msg success");
    }
}
