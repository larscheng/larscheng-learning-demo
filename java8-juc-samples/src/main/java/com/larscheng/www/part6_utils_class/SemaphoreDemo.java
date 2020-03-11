package com.larscheng.www.part6_utils_class;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 信号量
 *
 * @author larscheng
 * @date 2020/3/11 15:15
 */
public class SemaphoreDemo {
    public static void main(String[] args) {

        //限制进入的请求数，线程数

        //抢车位，3个车位
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("司机 "+Thread.currentThread().getName()+ " 抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
