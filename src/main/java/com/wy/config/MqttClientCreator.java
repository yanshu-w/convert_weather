package com.wy.config;

import com.wy.domain.vo.MqttParam;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;


public class MqttClientCreator {

    private static final Map<String, MqttClient> clientMap = new ConcurrentHashMap<>();

    private static final Queue<MqttParam> mqttQueue = new LinkedList<>();

    public static MqttClient createMqttClient(String broker, String clientId, String username, String password) throws MqttException {
        MqttClient client = new MqttClient(broker, clientId, new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        options.setConnectionTimeout(60);
        options.setKeepAliveInterval(60);
        client.connect(options);
        return client;
    }

    public static MqttClient createMqttClient(MqttParam mqttParam) throws MqttException {
        MqttClient mqttClient = createMqttClient(mqttParam.getBroker(), mqttParam.getToken(), mqttParam.getUsername()
                , mqttParam.getPassword());
        push(mqttParam.getToken(), mqttClient);
        return mqttClient;
    }

    public static void push(String token, MqttClient mqttClient) {
        clientMap.put(token, mqttClient);
    }

    public static MqttClient get(String token) {
        return clientMap.get(token);
    }


    public static class ParamQueue {

        public static boolean add(MqttParam mqttParam) {
            return mqttQueue.add(mqttParam);
        }

        public static MqttParam poll() {
            return mqttQueue.poll();
        }
    }


}
