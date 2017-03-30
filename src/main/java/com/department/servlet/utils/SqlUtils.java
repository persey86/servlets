package com.department.servlet.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created on 30.03.17.
 */
public class SqlUtils {
    private SqlUtils(){}

    public static final String SELECT_FROM_DEPARTMENTS = "SELECT * from departments";



public static void closeConnection(Connection connection){
    if (connection!=null){
        try{
            connection.close();
        }catch (SQLException e){
            System.out.println("Error while closing connection");
        }
    }
}

    public static Connection getConnection() throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/deppMySQL","root","1");

    }
}
