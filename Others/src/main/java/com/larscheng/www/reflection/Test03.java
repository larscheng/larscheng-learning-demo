package com.larscheng.www.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 反射读取注解
 */
public class Test03 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c = Class.forName("com.larscheng.www.reflection.Student");

        System.out.println("---------获取类注解--------");
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        System.out.println("---------获取注解值--------");
        Annotation annotation = c.getAnnotation(TableLars.class);
        System.out.println(annotation+"  "+((TableLars) annotation).value());

        System.out.println("---------获取字段注解--------");
        Field name = c.getDeclaredField("name");
        Annotation[] annotations1 = name.getAnnotations();
        for (Annotation annotation1 : annotations1) {
            System.out.println(annotation1);
        }
        System.out.println("---------获取字段注解值--------");
        FieldLars nameAnnotation = name.getAnnotation(FieldLars.class);
        System.out.println(nameAnnotation+"  "+nameAnnotation.columnName());
        System.out.println(nameAnnotation+"  "+nameAnnotation.type());
        System.out.println(nameAnnotation+"  "+nameAnnotation.length());


    }


}
//自定义类注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableLars{
    String value();
}
//自定属性注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldLars{
    String columnName();
    String type();
    int length();
}

@TableLars(value = "db_student")
class Student {
    @FieldLars(columnName = "stu_id",type = "int",length = 10)
    private int id;

    @FieldLars(columnName = "db_name",type = "varchar",length = 64)
    private String name;

    @FieldLars(columnName = "stu_age",type = "int",length = 10)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}