package com.larscheng.www.part13_single;

/**
 * 描述:
 * 枚举单例
 *
 * @author larscheng
 * @date 2020/3/16 11:18
 */
public enum EnumSingleton {


    /***
     * 考虑到反射会破坏单例，根据反射的源码发现newInstance中对于枚举类型无法进行对象创建
     *
     * 所以使用枚举来实现单例
     *
     * */

    INSTANCE;


    private static class SingleDemo { }

    private static volatile SingleDemo singleDemo;

    EnumSingleton() {
        System.out.println(Thread.currentThread().getName() + " new ........");
    }

    public static SingleDemo getInstance() {
        if (singleDemo == null) {
            singleDemo = new SingleDemo();
//            synchronized (EnumSingleton.class) {
//                if (singleDemo == null) {
//                    singleDemo = new SingleDemo();
//                }
//            }
        }
        return singleDemo;
    }


}
