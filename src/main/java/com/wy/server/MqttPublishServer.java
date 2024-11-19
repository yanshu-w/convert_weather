package com.wy.server;


import com.wy.config.MqttClientCreator;
import com.wy.domain.vo.MqttParam;
import com.wy.utils.PrintErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * 发布消息服务
 */
@Component
@Slf4j
public class MqttPublishServer {

    @Resource
    private WeatherServer weatherServer;


    public void sendMessage(String content, MqttParam mqttParam) throws MqttException {

        //获取生产客户端
        MqttClient mqttClient = MqttClientCreator.get(mqttParam.getBroker());

        if (Objects.isNull(mqttClient)) {
            //创建生产客户端
            mqttClient = MqttClientCreator.createMqttClient(mqttParam);
        }

        MqttMessage message = new MqttMessage(content.getBytes());
        message.setQos(0);
        // 发布消息
        mqttClient.publish(mqttParam.getNoticeTopic(), message);
        log.info("发送消息完成");
    }


    /**
     * 一秒执行一次
     * 从队列获取数据去请求
     */
    @Scheduled(cron = "0/1 * * * * ? ")
    public void autoSendMessage() {

        MqttParam mqttParam = MqttClientCreator.ParamQueue.poll();
        if (Objects.isNull(mqttParam)) {
            return;
        }
        //执行查询天气 入库 发布消息
        try {
            //将返回值改成数组 发送多次
            List<String> weatherList = weatherServer.getWeather(mqttParam);
            for (String weather : weatherList) {
                sendMessage(weather, mqttParam);
            }
        } catch (Exception e) {
            log.error(PrintErrorUtil.print(e));
        }


    }

    /**
     * 每天凌晨1点执行
     * 清楚所有关闭所有连接客户端
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void stopAllClient() {
        //关闭所有连接
        Collection<MqttClient> mqttClients = MqttClientCreator.allClient();
        try {
            for (MqttClient mqttClient : mqttClients) {
                mqttClient.close();
            }
        } catch (Exception e) {
            log.error(PrintErrorUtil.print(e));
        }
        //清楚所有连接
        MqttClientCreator.clearClientMap();
    }


}
