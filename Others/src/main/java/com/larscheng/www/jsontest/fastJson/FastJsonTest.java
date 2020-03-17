package com.larscheng.www.jsontest.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.larscheng.www.jsontest.Course;
import com.larscheng.www.jsontest.Student;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 描述:
 * fastJson的api示例
 *
 * @author larscheng
 * @date 2019/11/19 19:37
 */
public class FastJsonTest {

    private final static Student LIMING = new Student("liming", 20, new Date());
    private final static String LIMING_STR = "{'age':20,'birthday':1574163958480,'name':'liming'}";

    private final static Course MATH = new Course("数学课", "高等代数");
    private final static Course CHINESE = new Course("语文课", "大学语文");
    private final static List<Course> COURSES = Arrays.asList(MATH, CHINESE);
    private final static String COURSES_STR = "[{'desc':'高等代数','name':'数学课'},{'desc':'大学语文','name':'语文课'}]";

    private final static JSONObject LIMING_MAP = new JSONObject();
        static {
            LIMING_MAP.put("name", "liming");
            LIMING_MAP.put("age", 20);
            LIMING_MAP.put("birthday", new Date());
        }

    public static void main(String[] args) {




        //######################################## toJSONString ################################################
        /*JavaBean--->JSONString*/
        System.err.println("JavaBean--->JSONString(默认无格式):");
        System.out.println(JSON.toJSONString(LIMING));
        System.err.println("JavaBean--->JSONString(带格式):");
        System.out.println(JSON.toJSONString(LIMING, true));
        System.err.println("JavaBean--->JSONString(日期格式化):");
        System.out.println(JSON.toJSONStringWithDateFormat(LIMING, "yyyy-MM-dd") + "\n");

        /*JSONObject--->JSONString*/
        System.err.println("JSONObject--->JSONString(带格式):");
        System.out.println(JSON.toJSONString(LIMING_MAP, true) + "\n");

        /*List<JavaBean>--->JSONString*/
        System.err.println("List<JavaBean>--->JSONString(默认双引号):");
        System.out.println(JSON.toJSONString(COURSES));
        System.err.println("List<JavaBean>--->JSONString(单引号):");
        System.out.println(JSON.toJSONString(COURSES, SerializerFeature.UseSingleQuotes));
        System.err.println("List<JavaBean>--->JSONString(单引号+带格式):");
        System.out.println(JSON.toJSONString(COURSES, SerializerFeature.UseSingleQuotes,SerializerFeature.PrettyFormat) + "\n");

        //######################################## parse/parseObject ################################################
        /*JSONString--->JSONObject*/
        System.err.println("JSONString--->JSONObject(parse):");
        JSONObject jsonObject1 = (JSONObject) JSON.parse(LIMING_STR);
        System.out.println(jsonObject1.toString());
        System.err.println("JSONString--->JSONObject(parseObject):");
        System.out.println(JSON.parseObject(LIMING_STR).toString() + "\n");


        System.err.println("JSONString--->JavaBean:");
        Student student1 = JSON.parseObject(LIMING_STR,Student.class);
        System.out.println(student1.hashCode()+"\t"+student1.toString());
        System.err.println("JSONString--->JavaBean:");
        Student student2 = JSON.parseObject(LIMING_STR,new TypeReference<Student>(){});
        System.out.println(student2.hashCode()+"\t"+student2.toString());

        //######################################## parse/parseArray ################################################

        /*JSONString--->JSONArray*/
        System.err.println("JSONString--->JSONArray(parse):");
        JSONArray jsonArray1 = (JSONArray) JSON.parse(COURSES_STR);
        System.out.println(jsonArray1.toString());
        System.err.println("JSONString--->JSONArray(parseArray):");
        System.out.println(JSON.parseArray(COURSES_STR).toString());

        System.err.println("JSONString--->List<JavaBean>:");
        List<Course> courses1 = JSON.parseArray(COURSES_STR,Course.class);
        System.out.println(courses1.hashCode()+"\t"+courses1.toString()+"\n");


        //######################################## toJSON/toJavaObject ################################################
        System.err.println("JavaBean--->JSONObject:");
        System.out.println(JSON.toJSON(LIMING));

        System.err.println("JSONObject--->JavaBean:");
        System.out.println(JSON.toJavaObject(LIMING_MAP,Student.class));
        System.out.println(LIMING_MAP.toJavaObject(Student.class));
        System.out.println((Student)LIMING_MAP.toJavaObject(new TypeReference<Student>(){}));
        System.out.println(LIMING_MAP.toJavaObject(new TypeReference<Student>(){}.getType())+"\n");
    }

}
