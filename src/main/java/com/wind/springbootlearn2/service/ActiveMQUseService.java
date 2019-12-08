package com.wind.springbootlearn2.service;


import javax.jms.Destination;

/**
 * ActiveMQ消息生产的接口
 * 向消息队列中发送消息
 */
public interface ActiveMQUseService {
    /**
     * 指定消息队列，还有消息
     */
    public void sendMessage(Destination destination, final String message);

    /**
     * 使用默认消息队列，发送消息
     */
    public void sendMessage(final String message);

}
