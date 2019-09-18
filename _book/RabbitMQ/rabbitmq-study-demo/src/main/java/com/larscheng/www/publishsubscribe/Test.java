package com.larscheng.www.publishsubscribe;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/8/21 13:29
 */
public class Test {
    public static void main(String[] args) {

        // Date and time with timezone in Java 8
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, america );
        System.out.println("Current date and time in a particular timezone : " + localtDateAndTime);
        System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
        // 上海时间
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime shanghaiZonedDateTime = ZonedDateTime.now(shanghaiZoneId);

        // 东京时间
        ZoneId tokyoZoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime tokyoZonedDateTime = ZonedDateTime.now(tokyoZoneId);
        // 东京时间
        ZoneId newZoneId = ZoneId.of("America/New_York");
        ZonedDateTime newZonedDateTime = ZonedDateTime.now(newZoneId);


        // 东京时间
        ZoneId ZoneId1 = ZoneId.of("GMT+08:00");
        ZonedDateTime newZonedDateTime1 = ZonedDateTime.now(ZoneId1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        System.out.println("上海时间: " + shanghaiZonedDateTime.format(formatter) +"时区："+shanghaiZonedDateTime.getOffset());
//        System.out.println("东京时间: " + tokyoZonedDateTime.format(formatter) +"时区："+tokyoZonedDateTime.getOffset());
//        System.out.println("纽约时间: " + newZonedDateTime.format(formatter) +"时区："+newZonedDateTime.getOffset());
        System.out.println("纽约时间: " + newZonedDateTime1.format(formatter) +"时区："+newZonedDateTime1.getOffset());


    }
}
