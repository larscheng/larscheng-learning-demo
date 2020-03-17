package com.larscheng.www.part14_cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 * cas测试
 *
 * @author larscheng
 * @date 2020/3/16 11:47
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1234);

        //cas
        System.out.println(atomicInteger.compareAndSet(1234, 1235));
        System.out.println(atomicInteger.compareAndSet(1234, 1233));
        System.out.println(atomicInteger.compareAndSet(1235, 1234));

        //aba
        System.out.println(atomicInteger.compareAndSet(1234, 2234));
        System.out.println(atomicInteger.compareAndSet(2234, 1234));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(1234, 3234));
        System.out.println(atomicInteger.get());


    }
}