package com.department.servlet.dao.impl;

/**
 * Created by user on 30.03.17.
 */
public class DepartmentRepositoryExceptions extends Exception {
    public DepartmentRepositoryExceptions(String message){
        super(message);
    }
public DepartmentRepositoryExceptions(String message, Throwable cause){
        super(message,cause);
}}

