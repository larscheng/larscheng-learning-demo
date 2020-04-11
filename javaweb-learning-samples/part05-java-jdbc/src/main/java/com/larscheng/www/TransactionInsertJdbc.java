package com.larscheng.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author: larscheng
 * @date: 2020/4/11 下午5:15
 * @description: JDBC 事务
 */
public class TransactionInsertJdbc {
    public static void main(String[] args) throws Exception {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis",
                "root", "123456");

        //false 开启自动提交
        connection.setAutoCommit(false);
        //sql1
        String sql = "insert into user(id,name) values(1,'111111111111')";
        int i1 = connection.prepareStatement(sql).executeUpdate();


        //sql2
        String sql2 = "insert into user(id,name) values(3,'33333333333')";
        int i2 = connection.prepareStatement(sql2).executeUpdate();


        //关闭资源
        connection.close();

    }

}
