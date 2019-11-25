package com.wind.springbootlearn2.controller;

import com.wind.springbootlearn2.domain.JsonData;
import com.wind.springbootlearn2.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/*
 * 异步任务controller类
 * 测试异步任务的执行
 * AsyncTask
 * */
@RestController
@RequestMapping("/api/async")
public class AsyncController {

    @Autowired
    private AsyncTask task;

    /*
     * 没有future返回的异步任务处理
     *  不处理task里面的结果所以时间很短就执行完成
     * */
    @GetMapping("/asynctask")
    public Object asyncTask() throws InterruptedException {
        long begin = System.currentTimeMillis();
        //因为AsyncTask里面的方法是异步的任务，不影响主线程里面的方法执行，
        //所以在上面的begin执行完成之后马上就执行下面的end，所以主线程耗时很短
        task.task1();
        task.task2();
        task.task3();

        long end = System.currentTimeMillis();
        long total = end - begin;
        System.out.println("总耗时=" + total);
        return new JsonData(200, total, "异步任务执行成功");
    }

    /*
     * 有future返回值得异步任务处理
     * 处理task的结果所以完成时间是最长时间的线程完成时间
`     * */
//    1）要把异步任务封装到类里面，不能直接写到Controller
//	  2）增加Future<String> 返回结果 AsyncResult<String>("task执行完成");
//	  3）如果需要拿到结果 需要判断全部的 task.isDone()
    @GetMapping("/futuretask")
    public Object asyncFutureTask() throws InterruptedException {
        long begin = System.currentTimeMillis();
        //因为AsyncTask里面的方法是异步的任务，因为下面死循环影响阻塞主线程执行
        //所以要等3个异步方法全部执行完成，完成时间为3个异步方法中，执行时间最长的那个
        Future<String> future4 = task.task4();
        Future<String> future5 = task.task5();
        Future<String> future6 = task.task6();

        //循环查看异步任务是否完成，isDone返回异步任务是否完成
        for (; ; ) {
            if (future4.isDone() && future5.isDone() && future6.isDone()) {
                System.out.println("task4,task5,task6异步任务已完成");
                break;
            }
        }

        long end = System.currentTimeMillis();
        long total = end - begin;
        System.out.println("总耗时=" + total);
        return new JsonData(200, total, "异步任务执行成功");
    }

}
