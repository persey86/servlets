package com.devcolibri.servlet.dao.impl;

import com.devcolibri.servlet.dao.DepartmentRepository;
import com.devcolibri.servlet.entities.Department;

import java.util.Date;
import java.util.List;

/**
 * Created by Anastasia on 13.08.2016.
 */
public class DepartmentRepositoryImpl implements DepartmentRepository {


    @Override
    public List<Department> getDepartments() {
        return null;
    }

    @Override
    public Department saveDepartment(String name, Date created) {
        return null;
    }

    @Override
    public Boolean deleteDepartment(Integer departmentId) {
        return null;
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return null;
    }

    @Override
    public Boolean updateDepartment(Integer id, String name, Date created) {
        return null;
    }
}
