package com.larscheng.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author: larscheng
 * @date: 2020/4/11 下午5:15
 * @description:
 */
public class SelectJdbc {
    public static void main(String[] args) throws Exception {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis",
                "root", "123456");

        //编写sql
        String sql = "select * from user";
        Statement statement = connection.createStatement();

        //执行sql
        ResultSet resultSet = statement.executeQuery(sql);

        //读取结果集
        while (resultSet.next()){
            System.out.println("id: "+resultSet.getObject(1));
            System.out.println("name: "+resultSet.getObject(2));
        }

        //关闭资源
        statement.close();
        connection.close();

    }
}
