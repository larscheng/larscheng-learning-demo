package com.larscheng.www.part8_juc_queue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 同步队列
 * <p>
 * 任意时间只能有一个线程去操作，并且其内只能存一个元素
 *
 * @author larscheng
 * @date 2020/3/11 16:25
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        SynchronousQueue synchronousQueue = new SynchronousQueue();


        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"添加1");
                synchronousQueue.put(1);
                System.out.println(Thread.currentThread().getName()+"添加2");
                synchronousQueue.put(2);
                System.out.println(Thread.currentThread().getName()+"添加3");
                synchronousQueue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

//
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(()->{
            try {
//                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"取出"+synchronousQueue.take());
//                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"取出"+synchronousQueue.take());
//                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName()+"取出"+synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
