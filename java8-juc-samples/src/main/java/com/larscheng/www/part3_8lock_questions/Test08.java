package com.larscheng.www.part3_8lock_questions;

import java.util.concurrent.TimeUnit;

/**
 * 描述:2个对象，2个线程，调用该对象的【静态同步方法】/【普通同步方法】，哪个先打印？
 *
 * 打电话 先打印
 *
 * static+synchronized 锁的是Class 类模板 , 当静态同步方法被调用 整个class被加锁
 * synchronized方法被调用phone2对象被锁，
 *
 * 2对象，两种加锁方式，所以谁快谁先打印
 *
 *
 * @author larscheng
 * @date 2020/3/5 13:56
 */
public class Test08 {


    public static void main(String[] args) throws InterruptedException {
        Phone8 phone1 = new Phone8();
        Phone8 phone2 = new Phone8();

        new Thread(() -> {
            phone1.sms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            phone2.call();
        }).start();
    }
}

class Phone8 {

    public static synchronized void sms() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }


    public  synchronized void call() {
        System.out.println("打电话");
    }
}
