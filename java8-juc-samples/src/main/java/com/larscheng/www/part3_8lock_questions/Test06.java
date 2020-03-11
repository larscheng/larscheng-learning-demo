package com.larscheng.www.part3_8lock_questions;

import java.util.concurrent.TimeUnit;

/**
 * 描述:1个对象，2个线程，调用该对象的【静态同步方法】/普通方法，哪个先打印？
 *
 * 听音乐 先打印
 *
 * static+synchronized 锁的是Class 类模板, 当静态同步方法被调用 整个class被加锁
 * 普通方法不用获取锁，等待锁，不受影响
 *
 * @author larscheng
 * @date 2020/3/5 13:56
 */
public class Test06 {


    public static void main(String[] args) throws InterruptedException {
        Phone6 phone = new Phone6();

        new Thread(() -> {
            phone.sms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            phone.music();
        }).start();
    }
}

class Phone6 {

    public static synchronized void sms() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }



    public  void music() {
        System.out.println("听音乐");
    }
}
