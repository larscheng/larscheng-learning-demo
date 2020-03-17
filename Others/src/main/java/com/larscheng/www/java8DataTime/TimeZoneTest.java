package com.larscheng.www.java8DataTime;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.time.ZoneId;
import java.util.*;

/**
 * 描述:
 * 时区测试
 *
 * @author larscheng
 * @date 2019/11/21 17:21
 */
public class TimeZoneTest {

    public static void main(String[] args) {

        //getAvailableIDs 获取Java支持的所有时区 ID
        JSONObject jsonObject = new JSONObject();
        Arrays.asList(TimeZone.getAvailableIDs()).forEach(a->jsonObject.put(a,a));
        System.out.println(JSON.toJSONString(jsonObject,true));

        //getAvailableIDs 根据 时间偏移量 来获取时区 ID
        //获取位于东3区的地区列表
        JSONObject obj = new JSONObject();
        Arrays.asList(TimeZone.getAvailableIDs(3*60*60*1000)).forEach(a->obj.put(a,a));
        System.out.println(JSON.toJSONString(obj,true));

        //getDefault 获取当前系统的默认时区
        System.out.println("获取当前系统的默认时区:"+TimeZone.getDefault());

        //getTimeZone(String ID) 根据时区ID来获取其对应的时区  时区ID:GMT+08:00
        System.out.println("根据时区 ID 来获取其对应的时区:"+TimeZone.getTimeZone("GMT+08:00"));
        //setDefault 设置当前系统的默认时区
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Minsk"));
        System.out.println("设置默认时区为(时区整体改变)："+TimeZone.getDefault());
        // getTimeZone(ZoneId zoneId) 根据ZoneId对象来获取其对应的时区
        System.out.println("根据zoneID获取时区"+TimeZone.getTimeZone(ZoneId.of("Europe/Minsk")));

        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        //getID() 获取该 TimeZone 对象的时区 ID
        System.out.println("时区ID："+timeZone.getID()+"\t"+timeZone);
        //setID() 设置该时区的时区ID
        timeZone.setID("Europe/Minsk");
        System.out.println("setID设置时区ID后(仅改变了时区ID)："+timeZone.getID()+"\t"+timeZone);


        //getDisplayName() 获取该 TimeZone 对象的时区名称
        System.out.println(TimeZone.getTimeZone("GMT+08:00").getDisplayName());
        System.out.println(TimeZone.getTimeZone("Asia/Shanghai").getDisplayName());
        System.out.println(TimeZone.getTimeZone("Europe/Minsk").getDisplayName());

        //getDisplayName(Locale locale) 获取该 TimeZone 对象的时区名称，并根据 Locale 对象进行国际化
        TimeZone shanghai = TimeZone.getTimeZone("Asia/Shanghai");
        System.out.println("时区名称: "+shanghai.getDisplayName(Locale.CHINA));
        System.out.println("timezone name: "+shanghai.getDisplayName(Locale.ENGLISH));
        System.out.println("时区名："+shanghai.getDisplayName(Locale.JAPANESE));

        //getDisplayName(boolean daylight, int style) 是否夏时令，是否显示全称
        System.out.println("夏令时时区全称: "+shanghai.getDisplayName(true,TimeZone.LONG));
        System.out.println("标准时区全称: "+shanghai.getDisplayName(false,TimeZone.LONG));
        System.out.println("夏令时时区简称: "+shanghai.getDisplayName(true,TimeZone.SHORT));
        System.out.println("标准时区简称: "+shanghai.getDisplayName(false,TimeZone.SHORT));


        //获取某一时间所在时区的时间偏移量
        TimeZone minsk =  TimeZone.getTimeZone(ZoneId.of("Europe/Minsk"));
        System.out.println(minsk);
        System.out.println("当前时间在 "+minsk.getDisplayName()+" 的时间偏移量："+minsk.getOffset(System.currentTimeMillis()));
        System.out.println("当前时间在 "+minsk.getDisplayName()+" 的时间原始偏移量："+minsk.getRawOffset());

        //useDaylightTime 查询时区是否使用夏令时America/Rosario
        System.out.println(shanghai.useDaylightTime());
        System.out.println(TimeZone.getTimeZone("Los_Angeles").useDaylightTime());
        //inDaylightTime 查询给定的日期是否在此时区的夏令时中
        System.out.println(shanghai.inDaylightTime(new Date()));
        //hasSameRules(TimeZone other) 判断两个时区除时区ID外其他规则是否相同
        System.out.println("上海和重庆时区规则是否一致： "+TimeZone.getTimeZone("Asia/Shanghai").hasSameRules(TimeZone.getTimeZone("Asia/Chongqing")));



    }

}
