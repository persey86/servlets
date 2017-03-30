package com.department.servlet.dao.impl.Actions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by user on 30.03.17.
 */
public interface Action {
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
