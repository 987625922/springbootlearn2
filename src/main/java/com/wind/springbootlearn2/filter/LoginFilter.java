package com.wind.springbootlearn2.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 过滤器
 * urlPatterns 过滤的请求链接
 * filterNmae 过滤器的名称
 */
@WebFilter(urlPatterns = "/api/filter/*", filterName = "loginFilter")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter init");
    }

    /**
     * 过滤器过滤的方法
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String username = req.getParameter("username");
        if ("user".equals(username)) { //如果是user用户，直接放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("LoginFilter过滤器 用户名不是user");
            out.close();
        }
    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter destroy");
    }
}
