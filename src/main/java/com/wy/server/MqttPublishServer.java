package com.wy.server;


import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 发布消息服务
 */
@Component
@Slf4j
public class MqttPublishServer {

    @Resource(name = "publishMqttClient")
    private MqttClient mqttClient;

    @Value("${mqtt.publish_topic}")
    private String topic;

    public void sendMessage(String content) throws MqttException {

        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(0);
        // 发布消息
        mqttClient.publish(topic, message);
        log.info("publish success");
    }


}
