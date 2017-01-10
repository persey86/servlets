package com.department.servlet.dao.impl;

import com.department.servlet.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created on 2017.
 */
public class DepartmentRepository {
    public List<Department> getDepartments() {
        Connection connection = null;
        List<Department> departments = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");
            PreparedStatement pStm = connection.prepareStatement("SELECT * from departments");
            ResultSet rs = pStm.executeQuery();
            while (rs.next()) {
                Department user = new Department();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setCreated(rs.getDate("created"));
                departments.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("it will never be");
                }
            }
        }
        return departments;
    }

    public Department saveDepartment(String name, Date created) {
    Connection connection = null;
    Department department = new Department();
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");
        PreparedStatement pStm = connection.prepareStatement("INSERT INTO departments (name, created) VALUES (?, ?)");
        pStm.setString(1, name);
        pStm.setDate(2, new java.sql.Date(created.getTime()));
        int executeUpdate = pStm.executeUpdate();

        department.setName(name);
        department.setCreated(created);
    }
    catch(SQLException e){
        e.printStackTrace();
    }
    catch(ClassNotFoundException e){
        e.printStackTrace();
    } finally{
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("it will never be");
            }
        }
    }

    return department;
}

    public boolean deleteDepartment(Integer id) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");
            PreparedStatement pStm = connection.prepareStatement("DELETE FROM departments WHERE id= ?");
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


    public Department getDepartmentById(Integer id) {
        Connection connection = null;
        Department department = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");
            PreparedStatement pStm = connection.prepareStatement("SELECT * from departments where departments.id = ?");
            pStm.setInt(1, id);
            ResultSet rs = pStm.executeQuery();

            while (rs.next()) {
                department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                department.setCreated(rs.getDate("created"));

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

        return department;
    }

    public Boolean updateDepartment(Integer id, String name, Date created) {
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");
                PreparedStatement pStm = connection.prepareStatement("UPDATE departments SET id = ?, name = ?, created = ? WHERE id = ?");
                pStm.setInt(1, id);
                pStm.setString(2, name);
                pStm.setDate(3, new java.sql.Date(created.getTime()));

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
