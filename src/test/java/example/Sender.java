package example;

import cn.hutool.json.JSONObject;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Sender {

    public static void main(String[] args) throws MqttException {
        System.out.println("Hello world!");


        String broker = "tcp://ict.xsjhwy.com:1883";
        String username = "xsjhwy";
        String password = "xsjhwy123456*";
        String clientId = "publish_client";
        String topic = "mqtt/cwea_wy_subscribe_topic";
//        String topic = "mqtt/test";

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("type", 4);
        jsonObject.put("token", "nN91Rur9uid002xHEl");
        jsonObject.put("hourlySteps", "3");
        jsonObject.put("dailySteps", "3");
        jsonObject.put("lat", "49.2072");
        jsonObject.put("lon", "102.6656");
        jsonObject.put("noticeTopic", "my_receive_topic");
        jsonObject.put("broker", "tcp://ict.xsjhwy.com:1883");
        jsonObject.put("username", "xsjhwy");
        jsonObject.put("password", "xsjhwy123456*");

        MqttClient client = new MqttClient(broker, clientId, new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        client.connect(options);

        MqttMessage message = new MqttMessage(jsonObject.toString().getBytes());

        message.setQos(0);
        // 发布消息
        client.publish(topic, message);
        System.out.println("Message published");
        System.out.println("topic: " + topic);
        System.out.println("message content: " + jsonObject);
        // 关闭连接
        client.disconnect();
        // 关闭客户端
        client.close();

    }
}