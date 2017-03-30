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
            connection = getConnection();
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
                user.setAge(rs.getInt("age"));
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

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/deppMySQL", "root", "1");
    }

    public User getUserById(Integer id) {
        Connection connection = null;
        User user = null;
        try {
            connection = getConnection();
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
                user.setAge(rs.getInt("age"));
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

    public Boolean updateUser(Integer id, String userName, String userSurname, String userEmail, java.util.Date created, Integer departmentId, Integer age) {
        Connection connection = null;
        try {
            connection = getConnection();

            PreparedStatement pStm = connection.prepareStatement("UPDATE users SET name = ?, surname = ?, email = ?,created = ?, department_id = ?, age = ? WHERE id = ?");
            pStm.setString(1, userName);
            pStm.setString(2, userSurname);
            pStm.setString(3, userEmail);
            pStm.setDate(4, new java.sql.Date(created.getTime()));
            pStm.setInt(5, departmentId);
            pStm.setInt(6, age);
            pStm.setInt(7, id);

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

    public User saveUser(String userName, String userSurname, String userEmail, java.util.Date created, Integer departmentId, Integer age) {
        Connection connection = null;
        User user = new User();
        try {
            connection = getConnection();
            PreparedStatement pStm = connection.prepareStatement("INSERT INTO users (name, surname, email, created, department_id, age) VALUES (?, ?, ?, ?, ?, ?)");
            pStm.setString(1, userName);
            pStm.setString(2, userSurname);
            pStm.setString(3, userEmail);
            pStm.setDate(4, new java.sql.Date(created.getTime()));
            pStm.setInt(5, departmentId);
            pStm.setInt(6, age);
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
            connection = getConnection();
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

    public List<User> getUsersByDepartmentId(Integer departmentIdInt) {
        Connection connection = null;
        List<User> users = new ArrayList<>();

        try {
            connection = getConnection();
            PreparedStatement pStm = connection.prepareStatement("SELECT * from users u where u.department_id = ?");
            pStm.setInt(1, departmentIdInt);
            ResultSet rs = pStm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setCreated(rs.getDate("created"));
                user.setDepartmentId(rs.getInt("department_id"));
                user.setAge(rs.getInt("age"));
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

    public User getUserByEmail(String email) {
        Connection connection = null;
        User user = null;
        try {
            connection = getConnection();
            PreparedStatement pStm = connection.prepareStatement("SELECT * from users u where u.email = ?");
            pStm.setString(1, email);
            ResultSet rs = pStm.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setCreated(rs.getDate("created"));
                user.setDepartmentId(rs.getInt("department_id"));
                user.setAge(rs.getInt("age"));
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

    public User getUserByEmailNotID(Integer id, String email) {
        Connection connection = null;
        User user = null;
        try {
            connection = getConnection();
            PreparedStatement pStm = connection.prepareStatement("SELECT * from users u where u.id <> ? AND u.email = ?");
            pStm.setInt(1, id);
            pStm.setString(2, email);
            ResultSet rs = pStm.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setEmail(rs.getString("email"));
                user.setCreated(rs.getDate("created"));
                user.setDepartmentId(rs.getInt("department_id"));
                user.setAge(rs.getInt("age"));
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
}
