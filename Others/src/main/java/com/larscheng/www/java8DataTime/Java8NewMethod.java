package com.larscheng.www.java8DataTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * 描述:
 * java8中新的时间处理工具
 *
 * @author larscheng
 * @date 2019/11/22 16:53
 */
public class Java8NewMethod {



    public static void main(String[] args) {


        //############### Clock ###################
        Clock clock = Clock.systemUTC();
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());
        System.out.println(Instant.now().toEpochMilli());
        Clock c1 = Clock.system(ZoneId.of("Asia/Shanghai"));
        Instant in = Instant.now(c1);
        System.out.println(in);



        //############### Duration ###################
        System.out.println();
        Duration duration = Duration.ofSeconds(6000);
        System.out.println("600s= "+duration.toMinutes()+"min");
        System.out.println(Duration.between(Instant.now(),Instant.now().plusSeconds(60)).toMillis());
        System.out.println();

        //############### Instant ###################
        System.out.println(Instant.EPOCH);
        Instant instant1 = Instant.now();
        System.out.println(instant1);
        System.out.println(instant1.getEpochSecond());
        Instant instant3 = instant1.plusSeconds(60);
        System.out.println(instant3);
        System.out.println("相差毫秒："+instant1.until(instant3,ChronoUnit.MILLIS));
        System.out.println("相差分钟："+instant1.until(instant3,ChronoUnit.MINUTES));
        System.out.println("相差天数："+instant1.until(instant3,ChronoUnit.DAYS));
        Instant instant2 = Instant.now(Clock.systemUTC());
        System.out.println(instant2);

        //############### LocalDateTime ###################
        System.out.println();
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now().plusDays(1));
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.of(LocalDate.now(),LocalTime.now()));


        //############### ZoneId ###################

        Set<String> strings = ZoneId.getAvailableZoneIds();

//        strings.iterator().forEachRemaining(System.out::println);

        System.out.println(ZoneId.systemDefault());

        System.out.println(ZoneId.SHORT_IDS);

        //############### ZonedDateTime ###################
        System.out.println(ZonedDateTime.now());
        System.out.println(ZonedDateTime.now(ZoneId.of("Africa/Cairo")));

        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().atZone(ZoneId.of("Africa/Cairo")));
        System.out.println(ZonedDateTime.of(LocalDateTime.now(),ZoneId.of("Africa/Cairo")));



        //############### str===>str ###################

        String date = "2019年11月25日";
        String date1 = "2019年11月25日";
        System.out.println(LocalDate.parse(date1,DateTimeFormatter.ofPattern("yyyy年MM月dd日")));

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:a");
        System.out.println(LocalDateTime.now().format(dateTimeFormatter1));
        System.out.println(LocalDateTime.now().format(dateTimeFormatter2));

        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
        System.out.println(DateTimeFormatter.ISO_ZONED_DATE_TIME.format(ZonedDateTime.now()));
        System.out.println(dateTimeFormatter1.format(LocalDateTime.now()));


        //############### long===>Instant ###################
        System.out.println(Instant.ofEpochMilli(System.currentTimeMillis()));
        //############### Date<===>Instant ###################
        System.out.println(new Date().toInstant());
        System.out.println(Date.from(Instant.now()));
        System.out.println(Calendar.getInstance().toInstant());







    }
}
