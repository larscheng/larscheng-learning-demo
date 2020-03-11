package com.larscheng.www.part3_8lock_questions;

import java.util.concurrent.TimeUnit;

/**
 * 描述:1个对象，2个线程，调用该对象的【静态同步方法】/【普通同步方法】，哪个先打印？
 *
 * 打电话 先打印
 *
 * static+synchronized 锁的是Class 类模板 , 当静态同步方法被调用 整个class被加锁
 * synchronized 锁的是调用者对象phone , 当同步方法被调用 对象phone被加锁
 *
 * 1个对象，2种加锁方式，则是2把锁，所以互不干扰，谁执行快谁打印
 *
 * @author larscheng
 * @date 2020/3/5 13:56
 */
public class Test05 {


    public static void main(String[] args) throws InterruptedException {
        Phone5 phone = new Phone5();

        new Thread(() -> {
            phone.sms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            phone.call();
        }).start();
    }
}

class Phone5 {

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
