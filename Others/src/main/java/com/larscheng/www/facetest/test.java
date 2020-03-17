package com.larscheng.www.facetest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 描述:
 *
 * @author larscheng
 * @date 2020/3/12 13:17
 */
public class test {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("1");
////        list.add("2");
////        list.add("2");
////        list.add("2");
////        list.add("2");
////        list.add("2");
//
//        for (String str : list){
//            if ("1".equals(str)) {
//                list.remove(str);
//            }
//        }
//
//        System.out.println(list);




        int2bytes(21112311);

    }
    private static void int2bytes(int a ){
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (a>>24);
        bytes[1] = (byte) (a>>16);
        bytes[2] = (byte) (a>>8);
        bytes[3] = (byte) a;

        for (byte bytes1: bytes){
            System.out.println(bytes1);
        }

        int int1 = (bytes[0]&0xff)<<24;
        int int2 = (bytes[1]&0xff)<<16;
        int int3 = (bytes[2]&0xff)<<8;
        int int4 = (bytes[3]&0xff);


        System.out.println("--------------------");
        System.out.println(int1|int2|int3|int4);
    }
}
