package com.larscheng.www.part2_producer_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 * 利用juc下的工具类实现生产者消费者模型
 * <p>
 * sycnchronized    wait    notifyall
 * Lock             await   signal
 *
 * @author larscheng
 * @date 2020/3/5 10:54
 */
public class JucProducerConsumerDemo01 {


    public static void main(String[] args) {

        Data data = new Data();


        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                data.product();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                data.consume();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                data.product();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                data.consume();
            }
        }, "D").start();
    }

    static class Data {

        //库存数量
        private int num = 0;

        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void product() {
            lock.lock();
            try {
                while (num != 0) {
                    //等待: 库存还有不用生产
                    condition.await();
                }
                //业务: 生产1个产品
                num++;
                System.out.println(Thread.currentThread().getName() + " => " + num);
                //通知: 消费者可以来消费了
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }


        public void consume() {
            lock.lock();
            try {
                while (num == 0) {
                    //等待: 库存为0
                    condition.await();
                }
                //业务: 消费1个产品
                num--;
                System.out.println(Thread.currentThread().getName() + " => " + num);
                //通知: 生产者快来生产
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}

