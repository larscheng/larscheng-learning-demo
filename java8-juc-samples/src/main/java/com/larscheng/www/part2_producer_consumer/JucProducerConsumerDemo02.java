package com.larscheng.www.part2_producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 * juc实现生产消费者有序唤醒，有序执行
 * 多condition
 * num  1=>A 2=>B 3=>C
 * @author larscheng
 * @date 2020/3/5 11:22
 */
public class JucProducerConsumerDemo02 {


    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{for (int i=0;i<10;i++) data.printA();},"A").start();
        new Thread(()->{for (int i=0;i<10;i++) data.printB();},"B").start();
        new Thread(()->{for (int i=0;i<10;i++) data.printC();},"C").start();
    }
}

class Data{
    private int num=1;

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();


    public void printA(){
        //获取锁
        lock.lock();
        try {
            //判断等待
            while (num!=1){
                conditionA.await();
            }
            //业务执行
            System.out.println(Thread.currentThread().getName()+"===> aaa, num="+num);
            num = 2;
            //精准通知
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }
    public void printB(){
        //获取锁
        lock.lock();
        try {
            //判断等待
            while (num!=2){
                conditionB.await();
            }
            //业务执行
            System.out.println(Thread.currentThread().getName()+"===> bbb, num="+num);
            num = 3;
            //精准通知
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }
    public void printC(){
        //获取锁
        lock.lock();
        try {
            //判断等待
            while (num!=3){
                conditionC.await();
            }
            //业务执行
            System.out.println(Thread.currentThread().getName()+"===> ccc, num="+num);
            num = 1;
            //精准通知
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }
}