package com.larscheng.www.sharedelayqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 *
 * @author larscheng
 * @date 2020/3/17 11:25
 */
public class DelayQueueTestDemo {
        public static void main(String[] args) {
            DelayQueue<DelayData> delayQueue = new DelayQueue<>();

            //生产者线程
            new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    long currentTime = System.nanoTime();
                    //返回指定原点(包括)和指定边界(排除)之间的伪随机长值
                    long validTime = ThreadLocalRandom.current().nextLong(1000000000L, 7000000000L);
                    DelayData delayData = new DelayData(currentTime + validTime);
                    delayQueue.put(delayData);
                    System.out.println(Thread.currentThread().getName() + ": put ->" + delayData);
                    //模拟延时
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "生产者").start();

            //消费者线程
            new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": take -> " + delayQueue.take());
                        Thread.yield();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "消费者").start();

        }
    }

    /**
     * 队列元素必须实现Delayed接口,重写getDelay和compareTo方法
     */
    class DelayData implements Delayed {

        /**
         * 数据过期时间
         */
        private long delayTime;

        public DelayData(long delayTime) {
            this.delayTime = delayTime;
        }

        /**
         * 返回剩余有效时间
         *
         * @param unit 时间单位  纳秒
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.delayTime - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (o == this) {
                return 0;
            }
            if (o instanceof DelayData) {
                DelayData x = (DelayData) o;
                // 优先比较失效时间
                long diff = this.delayTime - x.delayTime;
                return diff < 0 ? -1 : diff > 0 ? 1 : 0;
            }
            long diff = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
            return (diff < 0) ? -1 : (diff > 0) ? 1 : 0;
        }

        @Override
        public String toString() {
            return "DelayData{" +
                    "delayTime=" + delayTime +
                    '}';
        }

}