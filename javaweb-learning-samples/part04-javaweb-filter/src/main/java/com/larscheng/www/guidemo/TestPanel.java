package com.larscheng.www.guidemo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: larscheng
 * @date: 2020/4/11 下午4:10
 * @description: gui 监听器
 */
public class TestPanel {
    public static void main(String[] args) {
        /*窗体*/
        Frame frame = new Frame("啦啦啦啦啦啦啦");
        /*面板*/
        Panel panel = new Panel(null);
        //布局
        frame.setLayout(null);
        //窗体位置，背景
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(255, 231, 243));

        //面板位置，背景
        panel.setBounds(300,300,300,300);
        panel.setBackground(new Color(221, 255, 229));

        frame.add(panel);

        frame.setVisible(true);


        //添加关闭的监听事件
        frame.addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window has been opened.
             *
             * @param e
             */
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("opening.........");
            }

            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("closing.........");
                System.exit(0);
            }

            /**
             * Invoked when a window has been closed.
             *
             * @param e
             */
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("closed.........");
                //0 正常关闭，1非正常
                System.exit(0);
            }

            /**
             * Invoked when a window is activated.
             *
             * @param e
             */
            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("显示.........");
            }

            /**
             * Invoked when a window is de-activated.
             *
             * @param e
             */
            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("最小化.........");
            }
        });
    }
}
