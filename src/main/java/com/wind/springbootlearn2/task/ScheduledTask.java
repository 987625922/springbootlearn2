package com.wind.springbootlearn2.task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
 * todo 定时任务业务类
 *
 * @Scheduled 开启定时任务注解
 * */
//	1、cron 定时任务表达式 @Scheduled(cron="*/1 * * * * *") 表示每秒
//              1）crontab 工具  https://tool.lu/crontab/
//  2、fixedRate: 定时多久执行一次（上一次开始执行时间点后xx秒再次执行；）
//  3、fixedDelay: 上一次执行结束时间点后xx秒再次执行
//  4、fixedDelayString:  字符串形式，可以通过配置文件指定
@Component
public class ScheduledTask {

    /*
    * 定时任务方法
    * 每隔2秒输出当前时间
    * */
//    @Scheduled(fixedRate = 2000) 每隔2秒输出
//    @Scheduled(cron = "*/1 * * * * *") 每一秒执行一次，可自定义执行时间
    public void sumit() {
        System.out.println("当前时间：" + new Date());
    }
}
