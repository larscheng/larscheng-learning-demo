package com.larscheng.www.part12_jmm_volatile;

/**
 * 描述:
 * volatile 保证可见性，但是不保证原子性
 *
 * @author larscheng
 * @date 2020/3/13 13:44
 */
public class VolatileDemo {



    private static volatile int num = 0;

    //可使用lock或者synchronized来解决原子性问题
    private static void add(){
        num++;
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
