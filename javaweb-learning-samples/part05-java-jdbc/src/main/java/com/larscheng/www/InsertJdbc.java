package com.larscheng.www;

import java.sql.*;

/**
 * @author: larscheng
 * @date: 2020/4/11 下午5:15
 * @description:
 */
public class InsertJdbc {
    public static void main(String[] args) throws Exception {
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis",
                "root", "123456");

        //编写sql(预处理)
        String sql = "insert into user(id,name) values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //填入参数
        preparedStatement.setInt(1,5);
        preparedStatement.setString(2,"larrrrrrrrrrrrrrs");

        //执行sql
        int i = preparedStatement.executeUpdate();

        if (i>0){
            System.out.println("插入成功................");
        }

        //关闭资源
        preparedStatement.close();
        connection.close();

    }
}
