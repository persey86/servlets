package com.department.servlet.dao.impl;



import com.department.servlet.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017.
 */
public class UserRepository {
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
                user.setEmail(rs.getString("email"));
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

    public User getUserById(Integer id) {
        Connection connection = null;
        User user = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");
            PreparedStatement pStm = connection.prepareStatement("SELECT * from users u where u.id = ?");
            pStm.setInt(1, id);
            ResultSet rs = pStm.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setCreated(rs.getDate("created"));
                user.setDepartmentId(rs.getInt("department_id"));
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

        return user;
    }

    public Boolean updateUser(Integer id, String userName, String userSurname, String userEmail, java.util.Date created, Integer departmentId) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");

            PreparedStatement pStm = connection.prepareStatement("UPDATE users SET name = ?, surname = ?, email = ?,created = ?, department_id = ? WHERE id = ?");
            pStm.setString(1, userName);
            pStm.setString(2, userSurname);
            pStm.setString(3, userEmail);
            pStm.setDate(4, new java.sql.Date(created.getTime()));
            pStm.setInt(5, departmentId);
            pStm.setInt(6, id);

            int executeUpdate = pStm.executeUpdate();

           return executeUpdate > 0;

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

        return false;
    }

    public User saveUser(String userName, String userSurname, String userEmail, java.util.Date created, Integer departmentId) {
        Connection connection = null;
        User user = new User();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");
            PreparedStatement pStm = connection.prepareStatement("INSERT INTO users (name, surname, email, created, department_id) VALUES (?, ?, ?, ?, ?)");
            pStm.setString(1, userName);
            pStm.setString(2, userSurname);
            pStm.setString(3, userEmail);
            pStm.setDate(4, new java.sql.Date(created.getTime()));
            pStm.setInt(5, departmentId);
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


    public Boolean deleteUser(Integer id){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");
            PreparedStatement pStm = connection.prepareStatement("DELETE FROM users WHERE id= ?");
            pStm.setInt(1, id);
            int executeUpdate = pStm.executeUpdate();

            return executeUpdate > 0;

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
        return false;
    }
}