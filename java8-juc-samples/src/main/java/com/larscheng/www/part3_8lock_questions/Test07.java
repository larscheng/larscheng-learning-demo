package com.larscheng.www.part3_8lock_questions;

import java.util.concurrent.TimeUnit;

/**
 * 描述:2个对象，2个线程，调用该对象的【静态同步方法】，哪个先打印？
 *
 * 发短信 先打印
 *
 * static+synchronized 锁的是Class 类模板 , 当静态同步方法被调用 整个class被加锁
 * 创建类的对象需要类模板，class被锁了，2个对象，只有1把锁，所以谁先拿到锁谁先执行，另一个必须等着
 *
 *
 * @author larscheng
 * @date 2020/3/5 13:56
 */
public class Test07 {


    public static void main(String[] args) throws InterruptedException {
        Phone7 phone1 = new Phone7();
        Phone7 phone2 = new Phone7();

        new Thread(() -> {
            phone1.sms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            phone2.call();
        }).start();
    }
}

class Phone7 {

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
