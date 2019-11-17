package com.wind.springbootlearn2.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 原生servlet监听器使用
 * 如果配合springboot来使用需要再application中加@ServletComponentScan进行扫描
 */
//@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("===RequestListener requestInitialized===");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("===RequestListener requestDestroyed===");
    }
}
