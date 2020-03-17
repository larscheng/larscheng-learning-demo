package com.larscheng.www.java8DataTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

/**
 * 描述:
 * 时间日期格式化测试
 *
 * @author larscheng
 * @date 2019/11/22 15:06
 */
public class DateTimeFormatTest {


    public static void main(String[] args) {

        Date now = new Date();

        /***
         *
         *@see java.text.DateFormat
         */
        DateFormat date = DateFormat.getDateInstance();
        DateFormat time = DateFormat.getTimeInstance();
        DateFormat all = DateFormat.getDateTimeInstance();
        System.out.println(date.format(now));
        System.out.println(time.format(now));
        System.out.println(all.format(now));


        System.out.println();
        date = DateFormat.getDateInstance(DateFormat.LONG);
        time = DateFormat.getTimeInstance(DateFormat.LONG);
        all = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.FULL);
        System.out.println(date.format(now));
        System.out.println(time.format(now));
        System.out.println(all.format(now));


        System.out.println();
        date = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
        time = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.CHINA);
        all = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.ENGLISH);
        System.out.println(date.format(now));
        System.out.println(time.format(now));
        System.out.println(all.format(now));


        /***
         *
         *
         *@see java.text.SimpleDateFormat
         * 占位符：
         *
         * G　　"公元"
         * y　　四位数年份
         * M　　月
         * d　　日
         * h　　时 在上午或下午 (1~12)
         * H　　时 在一天中 (0~23)
         * m　　分
         * s　　秒
         * S　　毫秒
         *
         * E　　一周中的周几
         * D　　一年中的第几天
         * w　　一年中第几个星期
         * a　　上午 / 下午 标记符
         * k 　 时(1~24)
         * K 　 时 在上午或下午 (0~11)
         */
        System.out.println();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(now));
        simpleDateFormat = new SimpleDateFormat("y年的第D天");
        System.out.println(simpleDateFormat.format(now));

        String a = threadLocal1.get().format(now);
        System.out.println("线程安全："+a);

        /***
         *@see java.time.format.DateTimeFormatter
         */
        System.out.println();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        DateTimeFormatter allFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT);
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("y-M-d H:m:s");

        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println(dateFormatter.format(dateTime));
        System.out.println(timeFormatter.format(dateTime));
        System.out.println(allFormatter.format(dateTime));
        System.out.println(myFormatter.format(dateTime));

    }
    private static ThreadLocal<DateFormat> threadLocal1 = ThreadLocal.withInitial(() -> new SimpleDateFormat("y-M-d H:m:s"));

    private static ThreadLocal<DateFormat> threadLocal2 = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("y-M-d H:m:s");
        }
    };
}
