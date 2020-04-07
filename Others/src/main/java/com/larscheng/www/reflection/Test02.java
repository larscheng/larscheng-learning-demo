package com.larscheng.www.reflection;

import com.larscheng.www.sharedelayqueue.DelayDemo;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射获取泛型类型
 */
public class Test02 {


    //泛型参数
    public void test1(Map<String, DelayDemo> map,String str){
        System.out.println("1111111111111111");
    }

    //泛型参数
    public Map<DelayDemo,String> test2(){
        System.out.println("222222222222222");
        return new HashMap<>();
    }





    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class c = Class.forName("com.larscheng.www.reflection.Test02");
        Method test1 = c.getDeclaredMethod("test1", Map.class, String.class);
        Type[] genericParameterTypes = test1.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("@@@: "+genericParameterType);
            if (genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }

        System.out.println("----------获取泛型类型的返回值类型---------------");
        Method test2 = c.getDeclaredMethod("test2");
        Type genericReturnType = test2.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }

}
