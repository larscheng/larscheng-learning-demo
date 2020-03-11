package com.larscheng.www.part3_8lock_questions;

import java.util.concurrent.TimeUnit;

/**
 * 描述:2个对象，2个线程，调用2对象的2同步方法，哪个先执行？
 *
 * 打电话先打印
 *
 * 2个对象，2个进程分开调用，2把锁，锁的2个对象，之间互不相关，
 * sms需要睡眠，call不用睡眠，所以打电话先打印
 *
 *
 * @author larscheng
 * @date 2020/3/5 13:56
 */
public class Test03 {


    public static void main(String[] args) throws InterruptedException {
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

        new Thread(() -> {
            phone1.sms();
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            phone2.call();
        }).start();
    }
}

class Phone3 {

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
