package com.wy.config;

import com.wy.domain.vo.MqttParam;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;


public class MqttClientCreator {

    private static final Map<String, MqttClient> clientMap = new ConcurrentHashMap<>();

    private static final Queue<MqttParam> mqttQueue = new ConcurrentLinkedQueue<>();

    public static MqttClient createMqttClient(String broker, String clientId, String username, String password) throws MqttException {
        MqttClient client = new MqttClient(broker, clientId, new MemoryPersistence());

        MqttConnectOptions options = createOptions(username, password);

        client.connect(options);
        return client;
    }

    public static MqttConnectOptions createOptions(String username, String password) {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        options.setConnectionTimeout(60);
        //心跳机制
        options.setKeepAliveInterval(60);
        //自动重连
        options.setAutomaticReconnect(true);
        //清除会话
        options.setCleanSession(true);
        return options;
    }

    public static MqttClient createMqttClient(MqttParam mqttParam) throws MqttException {
        MqttClient client = createMqttClient(mqttParam.getBroker(), mqttParam.getToken(), mqttParam.getUsername(),
                mqttParam.getPassword());

        push(mqttParam.getBroker(), client);
        return client;
    }

    public static void push(String broker, MqttClient mqttClient) {
        clientMap.put(broker, mqttClient);
    }

    public static MqttClient get(String broker) {
        return clientMap.get(broker);
    }

    public static void clearClientMap() {
        clientMap.clear();
    }

    public static Collection<MqttClient> allClient() {
        return clientMap.values();
    }

    public static class ParamQueue {

        public static boolean add(MqttParam mqttParam) {
            return mqttQueue.add(mqttParam);
        }

        public static MqttParam poll() {
            return mqttQueue.poll();
        }
    }

    public static class Reconnect {
        private static boolean CONNECTING = false;

        public static void start() {
            CONNECTING = true;
        }

        public static void finish() {
            CONNECTING = false;
        }

        public static Boolean running() {
            return CONNECTING;
        }

    }


}
