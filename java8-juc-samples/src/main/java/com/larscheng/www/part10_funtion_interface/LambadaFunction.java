package com.larscheng.www.part10_funtion_interface;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 描述:
 *  输出输出类函数式接口 Function
 * @author larscheng
 * @date 2020/3/12 11:35
 */
public class LambadaFunction {


    public static void main(String[] args) {


        System.out.println("----------方法型----------");

        /***
         * 输入输出型
         */
        Function<String, String> function = new Function<String, String>() {

            @Override
            public String apply(String s) {
                return "输出：" + s;
            }
        };
        System.out.println(function.apply("asdasdasda"));
        function = s->"打印："+s;
        System.out.println(function.apply("aaaaaaaaaa"));


        System.out.println("----------断定型----------");
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        System.out.println(predicate.test(""));
        predicate = String::isEmpty;
        System.out.println(predicate.test("123"));
        System.out.println("----------供给型----------");

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return UUID.randomUUID().toString().substring(0, 5);
            }
        };
        System.out.println(supplier.get());

        supplier = ()->UUID.randomUUID().toString().substring(0,5);
        System.out.println(supplier.get());

        System.out.println("----------消费型----------");

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("开始消费："+s);
            }
        };
        consumer.accept("msg1");

        consumer = s->System.out.println("开始消费："+s);
        consumer.accept("msg2");

        int a  = 123;
        Integer.bitCount(a);
    }


}
