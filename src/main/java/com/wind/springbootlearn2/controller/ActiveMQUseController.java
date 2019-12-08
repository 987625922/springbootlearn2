package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.domain.JsonData;
import com.wind.springbootlearn2.service.ActiveMQUseService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;


/**
 * ActiveMQ学习使用的controller
 *
 */
@RestController
@RequestMapping("/api/activemq")
public class ActiveMQUseController {

    @Autowired
    public ActiveMQUseService activeMQUseService;

    /**
     * 发送消息队列
     *
     */
    @GetMapping("sendcallback")
    public Object sendCallback(String msg){
        //生成消息目的地地址
        Destination destination = new ActiveMQQueue("wind-queue");
        activeMQUseService.sendMessage(destination,msg);
        return new JsonData(200,"","sendcallback发送消息队列成功");
    }


}
