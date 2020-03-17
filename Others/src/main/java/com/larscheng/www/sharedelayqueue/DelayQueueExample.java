package com.larscheng.www.sharedelayqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * 描述:
 *
 * @author larscheng
 * @date 2020/3/2 18:15
 */
public class DelayQueueExample {
    public static void main(String[] args) {
        BlockingQueue<DelayDemo> queue = new DelayQueue<DelayDemo>();
        for (int i = 1; i <= 10; i++) {
            try {
                //往队列中添加
                queue.put(new DelayDemo("task" + i, 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        ThreadGroup t = new ThreadGroup("Consumers");

        for (int i = 0; i <1 ; i++) {
            new Thread(t, new DelayConsumer(queue)).start();
        }


        while (DelayDemo.taskCount.get() > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        t.interrupt();
        System.out.println("Main thread finished");
    }
}
