package com.larscheng.www.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author: larscheng
 * @date: 2020/4/11 上午11:59
 * @description: 编码过滤器
 */
public class EncodingFilter implements Filter {
    //服务器启动就执行的初始化方法
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("EncodingFilter init................");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    //服务器停止时执行的销毁方法
    public void destroy() {
        System.out.println("EncodingFilter destroy................");
    }
}
