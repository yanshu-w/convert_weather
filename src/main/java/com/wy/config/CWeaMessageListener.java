package com.wy.config;

import com.wy.server.MqttPublishServer;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * 监听订阅消息接口
 */
@Slf4j
@Component
public class CWeaMessageListener implements IMqttMessageListener {

    @Resource
    private MqttPublishServer mqttPublishServer;

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        log.info("接收到的信息:" + new String(message.getPayload()));

        //执行查询天气 入库 发布消息

        mqttPublishServer.sendMessage("发布信息");
    }
}
