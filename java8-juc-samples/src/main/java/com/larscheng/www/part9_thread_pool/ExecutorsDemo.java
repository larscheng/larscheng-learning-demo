package com.larscheng.www.part9_thread_pool;

import java.util.concurrent.Executors;

/**
 * 描述: Executors 不推荐使用
 *
 * @author larscheng
 * @date 2020/3/11 16:53
 */
public class ExecutorsDemo {

    public static void main(String[] args) {
        //单线程池
        Executors.newSingleThreadExecutor();
        //固定线程数线程池
        Executors.newFixedThreadPool(5);
        //可伸缩性线程数线程数
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(3);


        // Executors创建线程池极其不推荐，其内部大量的使用Integer.MAX_VALUE做为最大线程数和阻塞队列的最大容量，
        // 会造成大量的请求堆积、或大量的阻塞线程，导致内存溢出


    }

}
