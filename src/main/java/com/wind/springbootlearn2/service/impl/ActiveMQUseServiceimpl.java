package com.wind.springbootlearn2.service.impl;

import com.wind.springbootlearn2.service.ActiveMQUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * ActiveMQ消息生产的实现类
 * 向消息队列中发送消息
 */
@Service
public class ActiveMQUseServiceimpl implements ActiveMQUseService {

    //发送消息队列的模板，用来发送到消息队列
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    /**
     * 指定消息队列，还有消息，发送消息,发送点对点消息
     *
     * @param destination 发送消息的队列
     * @param message     待发送的消息
     */
    @Override
    public void sendMessage(Destination destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

    /**
     * 发送消息
     *
     * @param message 待发送的消息
     */
    @Override
    public void sendMessage(String message) {
        jmsMessagingTemplate.convertAndSend(this.queue, message);
    }

    /**
     * ============================================ 发布订阅相关 ================================================
     */

    @Autowired
    public Topic topic;

    /**
     * 消息发布者，发送一个发送者对多个消费者的消息
     *
     * @param msg 待发送的消息文本
     */
    @Override
    public void publish(String msg) {
        jmsMessagingTemplate.convertAndSend(this.topic, msg);
    }
}
