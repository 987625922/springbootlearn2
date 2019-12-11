package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.domain.JsonData;
import com.wind.springbootlearn2.jms.RocketMQProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * RocketMQ学习用的controller
 *
 */
@RestController
@RequestMapping("/api/rocketmq")
public class RocketMQController {


    @Autowired
    private RocketMQProducer rocketMQProducer;

    /**
     * rocketmq发送消息
     *
     * @param msg 支付信息
     * @param tag 消息二级分类
     * @return
     */
    @GetMapping("send")
    public Object sendMessage(String msg, String tag) throws MQClientException, RemotingException, MQBrokerException,
            InterruptedException, UnsupportedEncodingException {

        /**
         * 创建一个消息实例，包含 topic、tag 和 消息体
         */
        Message message = new Message("TopicTest", tag, msg.getBytes(RemotingHelper.DEFAULT_CHARSET));

        SendResult result = rocketMQProducer.getProducer().send(message);

        System.out.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());

        return new JsonData(200, "", "");
    }


//	
//	/**
//	 * 功能描述：微信支付回调接口
//	 * @param msg 支付信息
//	 * @return
//	 */
//	@GetMapping("comment")
//	public Object comment(String msg) throws MQClientException, RemotingException, MQBrokerException, InterruptedException, UnsupportedEncodingException{
//	  
//		/**
//        * 创建一个消息实例，包含 topic、tag 和 消息体           
//       */
//       Message message = new Message("commentTopic","add", msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
//       
//       //同步的方式，会有返回结果,发送的是普通消息
//       SendResult result = msgProducer.getProducer().send(message);
//       
//       System.out.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
//     
//       return JsonData.buildSuccess();
//	}
//	
//	
//	


}
