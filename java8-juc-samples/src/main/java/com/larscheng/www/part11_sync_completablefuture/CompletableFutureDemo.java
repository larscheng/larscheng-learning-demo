package com.larscheng.www.part11_sync_completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 异步回调demo
 *
 * @author larscheng
 * @date 2020/3/13 11:33
 */
public class CompletableFutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("无返回值的异步回调");
        });

        System.out.println("继续执行.......");
        completableFuture1.get();


        System.out.println("----------------------------");
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            //手动失败
//            int a  = 10/0;
            return "有返回值的异步回调";
        });

        System.out.println("继续执行.......");

        completableFuture2.whenComplete((t,u)->{
            System.out.println("成功结果===>"+t);
            System.out.println("失败结果===>"+u);
        }).exceptionally((e)->{
            System.out.println("异常信息===>"+e.getMessage());
            return "404";
        });

        System.out.println(completableFuture2.get());
    }
}
