package com.larscheng.www.part3_8lock_questions;

import java.util.concurrent.TimeUnit;

/**
 * 描述:一个对象，2个线程，调用该对象的同步方法和普通方法，哪个先执行？
 *
 * 听音乐先打印
 *
 * 只有同步方法才会等待获取锁，普通方法不受限制
 *
 *
 *
 * @author larscheng
 * @date 2020/3/5 13:56
 */
public class Test02 {


    public static void main(String[] args) throws InterruptedException {
        Phone2 phone = new Phone2();

        new Thread(() -> {
            phone.sms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            phone.music();
        }).start();
    }
}

class Phone2 {

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

    public  void music() {
        System.out.println("听音乐");
    }
}
