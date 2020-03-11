package com.larscheng.www.part8_juc_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 阻塞队列
 *
 * @author larscheng
 * @date 2020/3/11 15:49
 */
public class BlockingQueueDemo {


    public static void main(String[] args) {

//        test1();
//        test2();
//        test3();
        test4();
    }

    /***
     * 抛出异常
     *
     * add          返回boolean， 队列超出容量抛出异常
     * remove       返回删除的元素值，队列为空抛出异常
     * element      返回队首元素，队列为空抛出异常
     */
    private static void test1() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        //add 返回boolean
        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        System.out.println(queue.add(3));
        //抛异常  java.lang.IllegalStateException: Queue full
        //System.out.println(queue.add(4));


        System.out.println("队列头部元素：" + queue.element());
        System.out.println("=========================");
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println("队列头部元素：" + queue.element());

        //抛异常 java.util.NoSuchElementException
        //System.out.println(queue.remove());
    }

    /**
     * 不抛异常
     * offer       返回boolean, 不抛异常
     * poll        返回元素值,不抛异常,队空返回null
     * peek        返回队首元素值,不抛异常,队空返回null
     */
    private static void test2() {

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        //offer 返回boolean
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        System.out.println(queue.offer(3));
        //不抛出异常，返回false
        System.out.println(queue.offer(4));


        System.out.println("队列头部元素：" + queue.peek());
        System.out.println("=========================");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        //不抛出异常 返回null
        System.out.println(queue.poll());
        System.out.println("队列头部元素：" + queue.peek());

    }

    /***
     * 一直等待，无返回值，无异常，一直阻塞
     * put  添加 无返回值
     * take 取出 返回元素值
     *
     */
    private static void test3() {

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        try {
            //put 无返回
            queue.put(1);
            ;
            queue.put(2);
            ;
            queue.put(3);
            ;
            //无返回值，一直阻塞
            queue.put(4);


            System.out.println("=========================");


            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());

            //一直阻塞
            System.out.println(queue.take());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /***
     * 超时等待，有返回值，无异常
     * offer(o,t)   添加 返回boolean ，t 超时时间
     * poll(t)      取出 返回元素值  ,t 超时时间
     *
     */
    private static void test4() {

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        //offer 返回boolean
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        System.out.println(queue.offer(3));

        try {
            //超过3秒就不等了，返回boolean
            System.out.println(queue.offer(4,3,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("=========================");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        try {
            //超过3秒就不等了，返回null
            System.out.println(queue.poll(3,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
