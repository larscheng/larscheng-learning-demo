package com.larscheng.www.java8DataTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 描述:
 * Calendar常用方法示例
 * @author larscheng
 * @date 2019/11/21 14:49
 */
public class CalendarTest {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        //get:返回指定日历字段的值
        System.out.println("#################### get #####################");
        System.out.println("当前日期:"+calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)
                +"-"+calendar.get(Calendar.DATE));
        System.out.println("当前时间:"+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)
                +":"+calendar.get(Calendar.SECOND)+":"+calendar.get(Calendar.MILLISECOND));
        System.out.println("12小时制:"+calendar.get(Calendar.HOUR));
        System.out.println("24小时制:"+calendar.get(Calendar.HOUR_OF_DAY));

        //set:设置日历字段的值
        System.out.println("#################### set #####################");
        calendar.set(Calendar.YEAR,2018);
        System.out.println("修改年份后："+calendar.get(Calendar.YEAR));
        calendar.set(2018, Calendar.MAY,13,15,1,11);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));


        //add:基于日历规则实现日期加减
        System.out.println("#################### add #####################");
        Calendar cal = Calendar.getInstance();
        System.out.println("当前月份："+(cal.get(Calendar.MONTH)+1));
        cal.add(Calendar.MONTH,2);
        System.out.println("加上2个月："+(cal.get(Calendar.MONTH)+1));
        cal.add(Calendar.MONTH,-2);
        System.out.println("再加上-2个月："+(cal.get(Calendar.MONTH)+1));

        //after、before：判断两个Calendar对象的先后（类似Date中的after、before）
        System.out.println("#################### after、before #####################");
        Calendar today = Calendar.getInstance();
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE,-1);
        System.out.println("after: "+ today.after(yesterday));
        System.out.println("before: "+ today.before(yesterday));
        System.out.println("before: "+ today.compareTo(yesterday));

        //clear:所有日历字段的值和时间值（从历元至现在的毫秒偏移量）设置为初始状态。
        System.out.println("#################### clear #####################");
        Calendar c = Calendar.getInstance();
        c.clear();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));

        //clone: 创建Calendar对象的副本，副本对象与源对象互不影响
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca1 = Calendar.getInstance();
        Calendar ca2 = Calendar.getInstance();
        ca1.add(Calendar.MONTH,3);
        ca2.roll(Calendar.MONTH,3);
        System.out.println(sf.format(ca1.getTime()));
        System.out.println(sf.format(ca2.getTime()));


        Calendar cccc = Calendar.getInstance();


    }
}
