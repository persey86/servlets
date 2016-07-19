package com.devcolibri.servlet;

import com.devcolibri.servlet.dao.impl.UserRepositoryImpl;
import com.devcolibri.servlet.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Anastasia on 06.07.2016.
 */
public class MainServlet extends HttpServlet {


    private UserRepositoryImpl userRepository = new UserRepositoryImpl();

    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String uri = req.getRequestURI();
        String method = req.getMethod();


        if (uri.equals("/") && method.equals("GET")) {
            List<User> users = userRepository.getUsers();
            req.setAttribute("name", "Devcolibri");
            req.setAttribute("users", users);

            req.getRequestDispatcher("/WEB-INF/mypage.jsp").forward(req, resp);
        } else if (uri.equals("/users") && method.equals("POST")) {
            String userName = req.getParameter("userName");
            String userSurname = req.getParameter("userSurname");
            userRepository.saveUser(userName, userSurname, new Date(), 4);
        } else if (uri.equals("/error")) {
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/error");
        }

    }
}
