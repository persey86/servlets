package com.department.servlet.dao.impl;

import com.department.servlet.entities.Department;
import com.department.servlet.utils.SqlUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.department.servlet.utils.SqlUtils.getConnection;

/**
 * Created on 2017.
 */
public class DepartmentRepository {
    public List<Department> getDepartments() throws DepartmentRepositoryExceptions {
        Connection connection = null;
        List<Department> departments = new ArrayList<>();
        try {
            connection = getConnection();
            PreparedStatement pStm = connection.prepareStatement(SqlUtils.SELECT_FROM_DEPARTMENTS);
            ResultSet rs = pStm.executeQuery();
            while (rs.next()) {
                Department user = new Department();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setCreated(rs.getDate("created"));
                departments.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DepartmentRepositoryExceptions("Error while getting all departments", e);
        } finally {
            SqlUtils.closeConnection(connection);
        }
        return departments;
    }

    public Department saveDepartment(String name, Date created) throws DepartmentRepositoryExceptions {
    Connection connection = null;
    Department department = new Department();
    try
    {
        connection = getConnection();
        PreparedStatement pStm = connection.prepareStatement("INSERT INTO departments (name, created) VALUES (?, ?)");
        pStm.setString(1, name);
        pStm.setDate(2, new java.sql.Date(created.getTime()));
        int executeUpdate = pStm.executeUpdate();

        department.setName(name);
        department.setCreated(created);
    }
    catch(SQLException | ClassNotFoundException e){
        throw new DepartmentRepositoryExceptions("Error SQL request", e);
    } finally{
        SqlUtils.closeConnection(connection);
    }
    return department;
}

    public boolean deleteDepartment(Integer id) throws DepartmentRepositoryExceptions {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement pStm = connection.prepareStatement("DELETE FROM departments WHERE id= ?");
            pStm.setInt(1, id);
            int executeUpdate = pStm.executeUpdate();

            return executeUpdate > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            SqlUtils.closeConnection(connection);
        }
        return false;
        }


    public Department getDepartmentById(Integer id) throws DepartmentRepositoryExceptions {
        Connection connection = null;
        Department department = null;
        try {
            connection = getConnection();
            PreparedStatement pStm = connection.prepareStatement("SELECT * from departments where departments.id = ?");
            pStm.setInt(1, id);
            ResultSet rs = pStm.executeQuery();

            while (rs.next()) {
                department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
                department.setCreated(rs.getDate("created"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new DepartmentRepositoryExceptions("Error", e);
        } finally {
            SqlUtils.closeConnection(connection);
        }
        return department;
    }

    public Boolean updateDepartment(Integer id, String name, Date created) throws DepartmentRepositoryExceptions{
            Connection connection = null;
            try {
                connection = getConnection();
                PreparedStatement pStm = connection.prepareStatement("UPDATE departments SET id = ?, name = ?, created = ? WHERE id = ?");
                pStm.setInt(1, id);
                pStm.setString(2, name);
                pStm.setDate(3, new java.sql.Date(created.getTime()));
                pStm.setInt(4, id);

                int executeUpdate = pStm.executeUpdate();

                return executeUpdate > 0;

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                SqlUtils.closeConnection(connection);
            }
            return false;
    }

}
