package com.devcolibri.servlet.dao;

import com.devcolibri.servlet.entities.Department;

import java.util.Date;
import java.util.List;

/**
 * Created by Anastasia on 13.08.2016.
 */
public interface DepartmentRepository {

    List<Department> getDepartments();

    Department saveDepartment(String name, Date created);

    Boolean deleteDepartment(Integer departmentId);

    Department getDepartmentById(Integer id);

    Boolean updateDepartment(Integer id, String name, Date created);

}
