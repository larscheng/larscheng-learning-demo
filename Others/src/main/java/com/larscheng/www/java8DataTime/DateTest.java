package com.larscheng.www.java8DataTime;

import java.util.Date;

/**
 * 描述:
 * Date的常用方式
 *
 * @author larscheng
 * @date 2019/11/21 13:46
 */
public class DateTest {
    public static void main(String[] args) {
        Date date1  = new Date();
        Date date2 = new Date(System.currentTimeMillis()+1000);
        System.out.println("date1: "+date1);
        System.out.println("date2: "+date2);
        System.out.println("date1.compareTo(date2): "+date1.compareTo(date2));
        System.out.println("date1.after(date2): "+date1.after(date2));
        System.out.println("date1.before(date2): "+date1.before(date2));
        System.out.println("date1.getTime(): "+date1.getTime());
        date1.setTime(System.currentTimeMillis());
        System.out.println("setTime() ==> date1.getTime(): "+date1.getTime());
    }
}
