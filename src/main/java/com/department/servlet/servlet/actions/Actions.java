package com.department.servlet.servlet.actions;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by user on 31.03.17.
 */
public interface Actions {
    String execute (HttpServletRequest request, HttpServletResponse response) throws Exception;
}
