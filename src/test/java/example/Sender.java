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

        //获取数据类型：1-实时；2-分钟（暂不可用）；3-小时级；4-天级别
        jsonObject.put("type", 1);
        //从后台获取的签名
        jsonObject.put("token", "xawl0N0mBN32gy8t14");
        //小时数（type=3必填）
        jsonObject.put("hourlySteps", "3");
        //天数（type=4必填）
        jsonObject.put("dailySteps", "3");
        //纬度
        jsonObject.put("lat", "49.2072");
        //经度
        jsonObject.put("lon", "102.6656");
        //接收的主题
        jsonObject.put("noticeTopic", "my_receive_topic");
        //接收的域名+端口
        jsonObject.put("broker", "tcp://ict.xsjhwy.com:1883");
        //用户名
        jsonObject.put("username", "xsjhwy");
        //密码
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