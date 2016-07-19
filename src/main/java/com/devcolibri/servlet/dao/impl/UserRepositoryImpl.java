package com.devcolibri.servlet.dao.impl;



import com.devcolibri.servlet.dao.UserRepository;
import com.devcolibri.servlet.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by Anastasia on 11.06.2016.
 */
public class UserRepositoryImpl implements UserRepository {

    @Override
    public List<User> getUsers() {
        Connection connection = null;
        List<User> users = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");
            PreparedStatement pStm = connection.prepareStatement("SELECT * from users u");
            ResultSet rs = pStm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setCreated(rs.getDate("created"));
                user.setDepartmentId(rs.getInt("department_id"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("it will never be");
                }
            }
        }

        return users;
    }

    @Override
    public User saveUser(String userName, String userSurname, java.util.Date created, Integer departmentId) {
        Connection connection = null;
        User user = new User();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");
            PreparedStatement pStm = connection.prepareStatement("INSERT INTO users (name, surname, created, department_id) VALUES (?, ?, ?, ?)");
            pStm.setString(1, userName);
            pStm.setString(2, userSurname);
            pStm.setDate(3, new java.sql.Date(created.getTime()));
            pStm.setInt(4, departmentId);
            int executeUpdate = pStm.executeUpdate();


            user.setDepartmentId(departmentId);
            user.setCreated(created);
            user.setName(userName);
            user.setSurname(userSurname);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("it will never be");
                }
            }
        }

        return user;
    }
}
