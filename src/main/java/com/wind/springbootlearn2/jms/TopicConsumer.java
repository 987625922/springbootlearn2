package com.wind.springbootlearn2.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * activemq订阅者类
 * 接收一对多消息（即发布订阅）
 * 里面有多个消费者（订阅者）
 */
@Component
public class TopicConsumer {


    /**
     * 订阅者一号（有多个，功能一样，只为测试多个订阅者的实现）
     * 接收activemq中一对多的消息，发送为ActiveMQUseController里的topic方法
     * containerFactory = "jmsListenerContainerTopic"是为了同时支持activemq的2种模式
     *
     * @param msg 接收到的文本
     */
    @JmsListener(destination = "video.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive1(String msg) {
        System.out.println("接收到一对多的消息，发送为ActiveMQUseController里的topic方法1：" + msg);
    }

    /**
     * 订阅者二号（有多个，功能一样，只为测试多个订阅者的实现）
     * 接收activemq中一对多的消息，发送为ActiveMQUseController里的topic方法
     * containerFactory = "jmsListenerContainerTopic"是为了同时支持activemq的2种模式
     *
     * @param msg 接收到的文本
     */
    @JmsListener(destination = "video.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive2(String msg) {
        System.out.println("接收到一对多的消息，发送为ActiveMQUseController里的topic方法2：" + msg);
    }

    /**
     * 订阅者三号（有多个，功能一样，只为测试多个订阅者的实现）
     * 接收activemq中一对多的消息，发送为ActiveMQUseController里的topic方法
     * containerFactory = "jmsListenerContainerTopic"是为了同时支持activemq的2种模式
     *
     * @param msg 接收到的文本
     */
    @JmsListener(destination = "video.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive3(String msg) {
        System.out.println("接收到一对多的消息，发送为ActiveMQUseController里的topic方法3：" + msg);
    }

}
