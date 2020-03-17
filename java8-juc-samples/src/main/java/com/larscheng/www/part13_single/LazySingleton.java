package com.larscheng.www.part13_single;

import java.lang.reflect.Constructor;

/**
 * 描述:
 * 懒汉式
 *
 * @author larscheng
 * @date 2020/3/16 10:31
 */
public class LazySingleton {

    private static LazySingleton singleton = null;

    private LazySingleton(){}

    /**线程非安全的懒汉式，多线程下会出现问题*/
    public static LazySingleton getInstance(){
        if (singleton==null){
            singleton =  new LazySingleton();
        }
        return singleton;
    }


    /**线程安全的懒汉式，双重检测锁模式*/
    public static LazySingleton getInstance2(){
        if (singleton==null){
            synchronized (LazySingleton.class){
                if (singleton==null){
                    singleton =  new LazySingleton();
                }
            }
        }
        return singleton;
    }


    public static void main(String[] args) throws Exception {
        //单例测试
        System.out.println(getInstance2());
        System.out.println(getInstance2());


        /***反射破坏单例**/
        Constructor<LazySingleton> declaredConstructor = LazySingleton.class.getDeclaredConstructor(null);
        //无视私有构造
        declaredConstructor.setAccessible(true);
        //直接调用构造方法
        LazySingleton lazySingleton = declaredConstructor.newInstance();
        //hashcode已改变
        System.out.println(lazySingleton);


    }
}
