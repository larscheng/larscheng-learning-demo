package com.larscheng.www.part12_jmm_volatile;

import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * java 内存模型
 *
 * @author larscheng
 * @date 2020/3/13 11:47
 */
public class JmmDemo {
    /***
     * JMM约定
     *
     * 线程加锁前，必须读取主存中的值到工作内存中
     * 线程解锁前，必须要把共享变量刷新回主存
     * 加锁解锁是同一把锁
     */


    /****JMM在多线程中，如果不进行同步处理，会导致问题******/




    //程序挂起
    private static  int num = 0;
    //保证可见性，num=1程序停止
    //private static volatile int num = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            while (num == 0) {
                //如果num==0就一直循环
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {

        }
        //num+1
        num++;

        //打印num，结束，但是！！！！ 子线程并不知道num已经为1，不会停止循环
        System.out.println(num);
    }
}
