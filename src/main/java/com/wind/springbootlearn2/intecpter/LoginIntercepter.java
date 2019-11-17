package com.wind.springbootlearn2.intecpter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * <p>
 * 拦截器的实现类，需要在CoustomerConfigrer拦截器配置类中配置才可以使用
 */
public class LoginIntercepter implements HandlerInterceptor {

    /**
     * 进入controller方法之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        System.out.println("LoginIntercepter preHandle");
        return HandlerInterceptor.super.preHandle(request,response,handler);
    }

    /**
     * 调用完controller之后，视图渲染之前
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("LoginIntercepter postHandle");
    }


    /**
     * 整个请求完成之后，通常用于资源清理
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        System.out.println("LoginIntercepter afterCompletion");
    }
}
