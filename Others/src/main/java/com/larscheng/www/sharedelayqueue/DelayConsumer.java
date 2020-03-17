package com.larscheng.www.sharedelayqueue;

import java.util.concurrent.BlockingQueue;

/**
 * 描述:
 *
 * @author larscheng
 * @date 2020/3/2 18:11
 */
public class DelayConsumer  extends Thread {
    private BlockingQueue<DelayDemo> queue = null;


    public DelayConsumer(BlockingQueue<DelayDemo> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {

        try {
            queue.take().startTask();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DelayDemo.taskCount.decrementAndGet();

    }
}
