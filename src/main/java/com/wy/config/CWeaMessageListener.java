package com.wy.config;

import com.wy.domain.vo.MqttParam;
import com.wy.server.MqttPublishServer;
import com.wy.server.WeatherServer;
import com.wy.utils.JsonUtil;
import com.wy.utils.PrintErrorUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;


/**
 * 监听订阅消息接口
 */
@Slf4j
@Component
public class CWeaMessageListener implements IMqttMessageListener {

    @SneakyThrows
    @Override
    public void messageArrived(String topic, MqttMessage message) {
        String msg = new String(message.getPayload());
        log.info("receive:" + msg);

        MqttParam mqttParam = JsonUtil.JsonToTarget(msg, MqttParam.class);

        if (Objects.isNull(mqttParam)) {
            log.error("未接收到消息");
            return;
        }
        //将param存入队列 依次执行
        MqttClientCreator.ParamQueue.add(mqttParam);
    }
}
