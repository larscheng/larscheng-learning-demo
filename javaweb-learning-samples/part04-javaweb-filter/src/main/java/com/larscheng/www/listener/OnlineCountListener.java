package com.larscheng.www.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author: larscheng
 * @date: 2020/4/11 下午3:56
 * @description: 监听器
 */

/***
 * 根据session统计网站在线人数
 */
public class OnlineCountListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount=1;
        }else {
            onlineCount++;
        }
        servletContext.setAttribute("onlineCount",onlineCount);
        System.out.println("创建session："+httpSessionEvent.getSession().getId());

    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) servletContext.getAttribute("onlineCount");
        if (onlineCount == null) {
            onlineCount=1;
        }else {
            onlineCount--;
        }
        servletContext.setAttribute("onlineCount",onlineCount);
        System.out.println("销毁session："+httpSessionEvent.getSession().getId());
    }
}
