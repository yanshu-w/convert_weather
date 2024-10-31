package com.wy.server;


import lombok.RequiredArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MqttServer {

    private final MqttClient mqttClient;




}
