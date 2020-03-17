package com.larscheng.www.jsontest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 描述:
 * 学生类
 *
 * @author larscheng
 * @date 2019/11/19 19:33
 */
@Data
@AllArgsConstructor
public class Student {

    private String name;
    private int age;
    private Date birthday;


}
