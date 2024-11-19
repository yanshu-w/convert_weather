package com.wy.config;


import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@Slf4j
public class MqttSubscribeConfig {

    @Resource
    private ReceiveMsgCallback receiveMsgCallback;

    @Resource
    private MqttServerProperty mqttServerProperty;

    @Bean(name = "subscribeMqttClient")
    public MqttClient subscribeMqttClient() throws MqttException {

        MqttClient client = MqttClientCreator.createMqttClient(mqttServerProperty.getBroker(),
                mqttServerProperty.getSubscribeClientId(), mqttServerProperty.getUsername(),
                mqttServerProperty.getPassword());

        client.subscribe(mqttServerProperty.getSubscribeTopic());

        client.setCallback(receiveMsgCallback);

        return client;
    }


}
