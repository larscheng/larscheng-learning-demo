package com.larscheng.www.part3_8lock_questions;

import java.util.concurrent.TimeUnit;

/**
 * 描述: 一个对象，2个线程，调用该对象的同步方法，哪个先执行？
 *
 * 发短信先执行
 *
 * 先拿到锁的先执行，未拿到锁的需要等待
 * synchronized关键字修饰方法，当同步方法被调用，锁的是调用方的对象，phone.sms()，被锁的是phone对象
 *
 *
 * @author larscheng
 * @date 2020/3/5 13:49
 */
public class Test01 {


    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();

        new Thread(() -> {
            phone.sms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            phone.call();
        }).start();
    }
}

class Phone {

    public synchronized void sms() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }


    public synchronized void call() {
        System.out.println("打电话");
    }
}
