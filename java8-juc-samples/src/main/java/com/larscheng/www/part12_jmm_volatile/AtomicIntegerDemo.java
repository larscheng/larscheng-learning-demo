package com.larscheng.www.part12_jmm_volatile;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 * volatile 保证可见性，但是不保证原子性
 *
 * @author larscheng
 * @date 2020/3/13 13:44
 */
public class AtomicIntegerDemo {



    //原子类解决同步问题，使用原子性操作
    private static volatile AtomicInteger num = new AtomicInteger();

    private static void add(){
        num.getAndIncrement();
    }
    public static void main(String[] args) {
        //6个线程去执行+1  最终理论结果应该是60000
        new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                add();
            }
        }).start();
        new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                add();
            }
        }).start();
        new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                add();
            }
        }).start();
        new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                add();
            }
        }).start();
        new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                add();
            }
        }).start();
        new Thread(() -> {
            for (int j = 0; j < 10000; j++) {
                add();
            }
        }).start();



        //gc\main
        while (Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+" "+ num);
    }
}
