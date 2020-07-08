package com.vuetests.bgsys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection {
    public static void main(String[] args) {
        Connection conn = null;
        String sql;
        // 此处为您的连接地址、端口、账号、密码等信息。
       /* String url = "jdbc:mysql://rm-bp18xb0cc9a0w1nbdto.mysql.rds.aliyuncs.com:3306?zeroDateTimeBehavior=convertToNull&amp;"
                + "user=michael&amp;password=password&amp;useUnicode=true&amp;characterEncoding=UTF8";*/

       // 测试通过
        /*String url = "jdbc:mysql://rm-bp18xb0cc9a0w1nbdto.mysql.rds.aliyuncs.com:3307?zeroDateTimeBehavior=convertToNull&"
                + "user=alvin&password=alvinAndalice730&useUnicode=true&characterEncoding=UTF8";*/

        // 测试通过
        String url = "jdbc:mysql://rm-bp18xb0cc9a0w1nbdto.mysql.rds.aliyuncs.com:3307/db-nuts?zeroDateTimeBehavior=convertToNull&"
                + "user=alice&password=aliceandnuts&useUnicode=true&characterEncoding=UTF8";

        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            /*//切换库。
            String sqlusedb = "use test_5";
            int result1 = stmt.executeUpdate(sqlusedb);
            //创建表。
            sql = "create table teacher(NO char(20),name varchar(20),primary key(NO))";
            int result = stmt.executeUpdate(sql);
            //插入数据。
            if (result != -1) {
                sql = "insert into teacher(NO,name) values('2016001','wangsan')";
                result = stmt.executeUpdate(sql);
                sql = "insert into teacher(NO,name) values('2016002','zhaosi')";
                result = stmt.executeUpdate(sql);
                //查询数据。
               *//* sql = "select * from teacher";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("学号\t姓名");
                while (rs.next()) {
                    System.out
                            .println(rs.getString(1) + "\t" + rs.getString(2));
                }*//*
            }*/
            //捕捉异常。
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}