package com.oracle.jdbc;

import oracle.jdbc.OracleTypes;
import org.junit.Test;

import java.sql.*;

/**
 * @author misterWei
 * @create 2018年09月16号:23点46分
 * @mailbox mynameisweiyan@gmail.com
 */
public class OracleJdbcAndConnect {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@192.168.238.150:1521:xe";
        String userNanme = "manager";
        String password = "manager";
        Connection connection = DriverManager.getConnection(url, userNanme, password);
        Statement statement = connection.createStatement();
        ResultSet executeQuery = statement.executeQuery("select * from person");
        while (executeQuery.next()) {
            System.out.println(executeQuery.getString("pid"));
            System.out.println(executeQuery.getString("pname"));

        }
        connection.commit();
        statement.close();
        connection.close();
        executeQuery.close();
        System.gc();

    }

    @Test
    public void executeInsert() {
        try {

            Connection connection = getConnection();
            PreparedStatement callableStatement = connection.prepareStatement(" insert into person(pname,gender) values(?,?)");
            callableStatement.setObject(1, "王老五");
            callableStatement.setObject(2, 5);
            callableStatement.execute();
            connection.commit();
            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void function() {
        try {

            Connection connection = getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call p_yearsal(?,?)}");
            callableStatement.setObject(1,7844);
            callableStatement.registerOutParameter(2,OracleTypes.NUMBER);

            callableStatement.execute();
            System.out.println(callableStatement.getObject(2));
            callableStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.238.150:1521:xe";
            String userNanme = "manager";
            String password = "manager";
            Connection connection = DriverManager.getConnection(url, userNanme, password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

}
