package com.wy.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class MqttServerProperty {

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
}
