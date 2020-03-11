package com.larscheng.www.part6_utils_class;

import java.util.concurrent.CountDownLatch;

/**
 * 描述:
 * 减法计数器
 *
 * @author larscheng
 * @date 2020/3/11 14:58
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        //教室里5个同学走完才能关门

        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("学生 "+ finalI +" 溜了");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();


        System.out.println("人走完了，关门...." );


    }

}
