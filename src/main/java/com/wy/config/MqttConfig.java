package com.wy.config;


import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
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

    @Value("${mqtt.publish_clientId}")
    private String publishClientId;

    @Value("${mqtt.subscribe_clientId}")
    private String subscribeClientId;

    @Value("${mqtt.publish_topic}")
    private String publishTopic;

    @Value("${mqtt.subscribe_topic}")
    private String subscribeTopic;

    @Bean(name = "publishMqttClient")
    public MqttClient publishMqttClient() throws MqttException {

        MqttClient client = getMqttClient(publishClientId);

        log.info("Message published");
        log.info("topic: " + publishTopic);

        return client;
    }

    @Bean(name = "subscribeMqttClient")
    public MqttClient subscribeMqttClient() throws MqttException {

        MqttClient client = getMqttClient(subscribeClientId);

        client.subscribe(subscribeTopic, cWeaMessageListener);

        return client;
    }

    private MqttClient getMqttClient(String clientId) throws MqttException {
        MqttClient client = new MqttClient(broker, clientId, new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        options.setConnectionTimeout(60);
        options.setKeepAliveInterval(60);
        client.connect(options);
        return client;
    }

}
