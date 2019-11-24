package com.wind.springbootlearn2.task;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/*
 * 异步任务业务类
 *
 * @Async 开启异步任务注解，标记一个方法，表示异步执行，也可以标识一个类，
 * 表示这个类里面的所有方法都是异步的
 * */
@Component
public class AsyncTask {

    @Async
    public void task1() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);//模拟耗时操作
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时=" + (end - begin));
    }

    @Async
    public void task2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);//模拟耗时操作
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时=" + (end - begin));
    }

    @Async
    public void task3() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);//模拟耗时操作
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时=" + (end - begin));
    }

    @Async
    public Future<String> task4() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);//模拟耗时操作
        long end = System.currentTimeMillis();
        System.out.println("任务4耗时=" + (end - begin));
        return new AsyncResult<String>("任务4");
    }

    @Async
    public Future<String> task5() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000L);//模拟耗时操作
        long end = System.currentTimeMillis();
        System.out.println("任务5耗时=" + (end - begin));
        return new AsyncResult<String>("任务5");
    }

    @Async
    public Future<String> task6() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000L);//模拟耗时操作
        long end = System.currentTimeMillis();
        System.out.println("任务6耗时=" + (end - begin));
        return new AsyncResult<String>("任务6");
    }

}
