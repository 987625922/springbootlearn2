package com.wind.springbootlearn2.service;


import javax.jms.Destination;

/**
 * ActiveMQ消息生产的接口
 * 向消息队列中发送消息
 */
public interface ActiveMQUseService {
    /**
     * 指定消息队列，还有消息，发送消息,发送点对点消息
     */
    public void sendMessage(Destination destination, final String message);

    /**
     * 使用默认消息队列，发送消息,发送点对点消息
     */
    public void sendMessage(final String message);

    /**
     * 消息发布者，发送一个发送者对多个消费者的消息
     */
    public void publish(String msg);
}
