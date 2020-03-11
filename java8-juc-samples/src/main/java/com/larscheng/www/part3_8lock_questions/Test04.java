package com.larscheng.www.part3_8lock_questions;

import java.util.concurrent.TimeUnit;

/**
 * 描述:1个对象，2个线程，调用该对象的【静态同步方法】，哪个先打印？
 *
 * 发短信先打印
 *
 * static+synchronized 锁的是Class 类模板 , 当静态同步方法被调用 整个class被加锁
 * 1个对象，都是静态同步方法，则是1把锁，所以谁先拿到谁先执行
 *
 * @author larscheng
 * @date 2020/3/5 13:56
 */
public class Test04 {


    public static void main(String[] args) throws InterruptedException {
        Phone4 phone = new Phone4();

        new Thread(() -> {
            phone.sms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            phone.call();
        }).start();
    }
}

class Phone4 {

    public static synchronized void sms() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }


    public static synchronized void call() {
        System.out.println("打电话");
    }
}
