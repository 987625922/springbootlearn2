package com.wind.springbootlearn2.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * activemq点对点的消息队列消费者
 * 消息从ActiveMQUseController发出
 */
@Component
public class ActiveMQConsumer {

    /**
     * 接收activemq里队列名为wind-queue的消息
     * 消息发送和接收为点对点
     * 接收activemquseController中的sendCallback接口消息
     *
     * @JmsListener 需要监听的消息队列
     */
    @JmsListener(destination = "wind-queue")
    public void receiveQueue(String str) {
        System.out.println("接收到wind-queue消息队列里的消息：" + str);
    }
}
