package com.oracle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author misterWei
 * @create 2018年09月16号:23点46分
 * @mailbox mynameisweiyan@gmail.com
 */
public class OracleJdbcAndConnect {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@192.168.238.144:1521:xe";
        String userNanme = "system";
        String password = "12345";
        Connection connection = DriverManager.getConnection(url, userNanme, password);
        Statement statement = connection.createStatement();
        ResultSet executeQuery = statement.executeQuery("select * from student");
        while (executeQuery.next()) {
            System.out.println(executeQuery.getString("s_id"));
            System.out.println(executeQuery.getString("s_name"));

        }
        connection.commit();
        statement.close();
        connection.close();
        executeQuery.close();
        System.gc();

    }


}
