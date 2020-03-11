package com.larscheng.www.part5_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 描述:
 * callableDemo
 *
 * 类似runnable，但他可以抛出异常，有个返回值，内部方法为call，而非run
 * @author larscheng
 * @date 2020/3/11 14:40
 */
public class CallAbleDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //启动Runnable
        new Thread(new MyThread1()).start();

        //如何启动Callable
        /***
         *
         * Thread只接受Runnable
         *
         * FutureTask是Runnable的实现类
         *
         * FutureTask的构造器可接受Runnable或Callable
         *
         * 所以使用FutureTask来传入Thread，调用start启动
         */

        FutureTask<String> stringFutureTask = new FutureTask<>(new MyThread2());

        new Thread(stringFutureTask).start();
        //有缓存,第二次的会缓存
        new Thread(stringFutureTask).start();

        //get会阻塞,可使用异步方式
        System.out.println(stringFutureTask.get());


    }
}

class MyThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println("exec Runnable.....");
    }
}
class MyThread2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("有缓存，只会在第一次执行...");
        return "return call()";
    }
}