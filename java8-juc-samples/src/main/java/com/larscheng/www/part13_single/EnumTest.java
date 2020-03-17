package com.larscheng.www.part13_single;

import java.lang.reflect.Constructor;

/**
 * 描述:
 *
 * @author larscheng
 * @date 2020/3/16 11:32
 */
public class EnumTest {


    public static void main(String[] args) throws NoSuchMethodException {


        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
//                System.out.println(EnumSingleton.getInstance());
                EnumSingleton.getInstance();
            }).start();
        }
    }
}
