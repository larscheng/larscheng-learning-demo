package com.larscheng.www.part6_utils_class;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 描述:
 * 加法计数器
 *
 * @author larscheng
 * @date 2020/3/11 15:05
 */
public class CycliBarrierDemo {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        //集齐七颗龙珠，召唤神龙
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> System.out.println("龙珠集齐了，召唤神龙....."));


        for (int i = 1; i <= 7; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("收集到第" + finalI + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
