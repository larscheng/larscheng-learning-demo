package com.larscheng.www.part9_thread_pool;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述: Executors 不推荐使用
 *
 * @author larscheng
 * @date 2020/3/11 16:53
 */
public class ExecutorsDemo {

    public static void main(String[] args) {
        //单线程池
        Executors.newSingleThreadExecutor().shutdown();
        //固定线程数线程池
        Executors.newFixedThreadPool(5).shutdown();
        //可伸缩性线程数线程数
        Executors.newCachedThreadPool().shutdown();
        Executors.newScheduledThreadPool(3).shutdown();


        // Executors创建线程池极其不推荐，其内部大量的使用Integer.MAX_VALUE做为最大线程数和阻塞队列的最大容量，
        // 会造成大量的请求堆积、或大量的阻塞线程，导致内存溢出

        new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        ).shutdown();

        new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "1");
                    }
                },
                new ThreadPoolExecutor.AbortPolicy()
        ).shutdown();

        final  AtomicInteger threadNumber = new AtomicInteger(1);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                (r) -> new Thread(r,"pool-1-thread-"+threadNumber.getAndIncrement()),
                //AbortPolicy，超过处理量，拒绝执行抛出异常
                //new ThreadPoolExecutor.AbortPolicy()
                //CallerRunsPolicy：拒绝执行，不抛出异常，回退给调用方执行
                //new ThreadPoolExecutor.CallerRunsPolicy()
                //DiscardPolicy：直接丢弃，不抛出异常
                //new ThreadPoolExecutor.DiscardPolicy()
                //DiscardOldestPolicy：尝试与最早的线程进行竞争，不抛出异常，尝试失败直接丢弃
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );

        for (int i = 1; i <=81 ; i++) {
            int finalI = i;
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+  " "+ finalI);
            });
        }

        threadPoolExecutor.shutdown();
    }

}
