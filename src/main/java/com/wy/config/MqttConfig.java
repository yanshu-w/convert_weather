package com.wy.config;


import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@Slf4j
public class MqttConfig {

    @Resource
    private CWeaMessageListener cWeaMessageListener;

    @Value("${mqtt.broker}")
    private String broker;

    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Value("${mqtt.subscribe_clientId}")
    private String subscribeClientId;

    @Value("${mqtt.subscribe_topic}")
    private String subscribeTopic;

    @Bean(name = "subscribeMqttClient")
    public MqttClient subscribeMqttClient() throws MqttException {

        MqttClient client = MqttClientCreator.createMqttClient(broker, subscribeClientId, username, password);

        client.subscribe(subscribeTopic, cWeaMessageListener);

        return client;
    }


}
