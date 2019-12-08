package com.wind.springbootlearn2.service.impl;

import com.wind.springbootlearn2.service.ActiveMQUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Queue;

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
     * 发送消息
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
}
