package com.larscheng.www.hashmap;

import java.util.HashMap;

/**
 * 描述:
 *
 * @author larscheng
 * @date 2020/2/27 17:49
 */
public class HashMapDemo1 {
    public static void main(String[] args) {
        String key = "name";
        String value = "lars";
        HashMap map = new HashMap();
        map.put(key, value);

        System.out.println("key的hashCode：" + key.hashCode());
        System.out.println("取模后index：" + key.hashCode() % 16);
        System.out.println("---------------------");

        System.out.println("key原本hash：" + key.hashCode());
        int a = hash(key.hashCode());
        System.out.println("---------------------------------- ^ "+"\n" + toBin(a));
        System.out.println("位干扰(异或)hash：" + a);
        int b = (15 & a);
        System.out.println(toBin(15));
        System.out.println(toBin(a));
        System.out.println("---------------------------------- & "+"\n" + toBin(b));
        System.out.println("位干扰(与)index：" + b);
    }

    /**
     *
     a ^ b ---> 异或运算：00得0 11得0 10得1 01得1
     a & b ---> 与运算  : 00得0 01得0 10得0 11得1
     * @param key
     * @return
     */
    private static int hash(Object key) {
        int h;
        System.out.println(toBin(key.hashCode()));
        System.out.println(toBin(key.hashCode()>>>16));
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    public static String toBin(int num) {
        char[] chs = new char[Integer.SIZE];
        for (int i = 0; i < Integer.SIZE; i++) {
            chs[Integer.SIZE - 1 - i] = (char) ((num >> i & 1) + '0');
        }
        return new String(chs);
    }
}
