package com.larscheng.www.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test01 {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {

        //反射获取类信息
        Class c = Class.forName("com.larscheng.www.sharedelayqueue.DelayDemo");

        //获取类信息
        System.out.println("==========类信息===========");
        System.out.println(c.getSimpleName());//类名
        System.out.println(c.getName());//全限定名
        System.out.println(c.getTypeName());
        System.out.println(c.getCanonicalName());

        System.out.println("==========子类父类public属性===========");
        for (Field field : c.getFields()) {
            //子类和父类的公有属性 public
            System.out.println(field);
        }
        System.out.println("===========本类所有属性==========");
        for (Field declaredField : c.getDeclaredFields()) {
            //子类和父类的所有属性
            System.out.println(declaredField);
        }
        System.out.println("==========指定属性===========");
        System.out.println(c.getField("taskName"));//指定public属性
        System.out.println(c.getDeclaredField("taskName"));//指定任意属性

        System.out.println("==========子类和父类所有public方法===========");
        for (Method method : c.getMethods()) {//所有public方法
            System.out.println(method);
        }
        System.out.println("==========本类所有方法===========");

        for (Method declaredMethod : c.getDeclaredMethods()) {
            System.out.println(declaredMethod);//任一方法
        }
        System.out.println("==========指定方法===========");

        System.out.println(c.getEnclosingMethod());
        System.out.println(c.getMethod("startTask"));
        System.out.println(c.getDeclaredMethod("startTask", null));

        System.out.println("==========构造方法===========");

        for (Constructor constructor : c.getConstructors()) {
            System.out.println(constructor);
        }
        System.out.println("==========所有构造方法===========");

        for (Constructor declaredConstructor : c.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }
        System.out.println("==========指定构造方法===========");
        System.out.println(c.getConstructor(String.class, int.class));

        System.out.println("==========注解===========");
        for (Annotation annotation : c.getAnnotations()) {
            System.out.println(annotation);
        }
    }

}
