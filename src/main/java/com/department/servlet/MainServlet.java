package com.department.servlet;

import com.department.servlet.dao.impl.DepartmentRepository;
import com.department.servlet.dao.impl.UserRepository;
import com.department.servlet.entities.Department;
import com.department.servlet.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created on 06.07.2016.
 */
public class MainServlet extends HttpServlet {



    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserRepository userRepository = new UserRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();


        String uri = request.getRequestURI();
        String method = request.getMethod();


        if (uri.equals("/") && method.equals("GET")) {
            List<User> users = userRepository.getUsers();
            List<Department> departments = departmentRepository.getDepartments();
            request.setAttribute("name", "Devcolibri");
            request.setAttribute("users", users);
            request.setAttribute("departments", departments);
            request.getRequestDispatcher("/WEB-INF/mypage.jsp").forward(request, response);
        } else if (uri.equals("/users") && method.equals("POST")) {

            // general functionality for add use and update user
            String id = request.getParameter("id");
            String userName = request.getParameter("userName");
            String userSurname = request.getParameter("userSurname");
            String userEmail = request.getParameter("userEmail");
            String departmentId = request.getParameter("departmentId");

            Integer departmentIdInt = Integer.parseInt(departmentId);

            if (id == null) {
                // if there is no id we create new user
                userRepository.saveUser(userName, userSurname, userEmail, new Date(), departmentIdInt);
            } else {
                // if id is not null we update user
                Integer idInt = Integer.parseInt(id);
                Boolean aBoolean = userRepository.updateUser(idInt, userName, userSurname, userEmail,new Date(), departmentIdInt);
                if (!aBoolean) {
                    // if there is no updated rows in database - redirect to error page
                    response.sendRedirect("/error");
                }
            }
            response.sendRedirect("/");

        } else if (uri.equals("/user/delete") && method.equals("POST")) {
            String userId = request.getParameter("departmentId");
            Integer userIdInt = Integer.parseInt(userId);
            userRepository.deleteUser(userIdInt);
            response.sendRedirect("/");
        } else if (uri.contains("/user/edit/") && method.equals("GET")) {
            String[] urlParams = uri.split("/");
            String userId = urlParams[urlParams.length - 1];
            Integer userIdInt = Integer.parseInt(userId);

            User currentUser = userRepository.getUserById(userIdInt);

            request.setAttribute("currentUser", currentUser);
            request.getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
        } else if (uri.equals("/error")) {
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        } else {
            response.sendRedirect("/error");
        }




        if (uri.equals("/") && method.equals("GET")) {
            List<Department> departments = departmentRepository.getDepartments();

            //   request.setAttribute("name", "Devcolibri");

            request.setAttribute("departments", departments);
            request.getRequestDispatcher("/WEB-INF/department.jsp").forward(request, response);
        } else if (uri.equals("/departments") && method.equals("POST")) {

            // general functionality for add use and update user

            String id = request.getParameter("id");
            String name = request.getParameter("name");

        }}}
//            if (id == null) {
//                // if there is no id we create new user
//                departmentRepository.saveDepartment(name, new Date());
//            } else {
//                // if id is not null we update user
//                Integer idInt = Integer.parseInt(id);
//                Boolean aBoolean = departmentRepository.updateDepartment(idInt, name, new Date());
//                if (!aBoolean) {
//                    // if there is no updated rows in database - redirect to error page
//                    response.sendRedirect("/error");
//                }
//            }
//            response.sendRedirect("/");
//
//        } else if (uri.equals("/department/delete") && method.equals("POST")) {
//            String id = request.getParameter("id");
//            Integer idInt = Integer.parseInt(id);
//            departmentRepository.deleteDepartment(idInt);
//            response.sendRedirect("/");
//        } else if (uri.contains("/user/edit/") && method.equals("GET")) {
//            String[] urlParams = uri.split("/");
//            String id = urlParams[urlParams.length - 1];
//            Integer idInt = Integer.parseInt(id);
//
//            Department currentDepartment = departmentRepository.getDepartmentById(idInt);
//
//            request.setAttribute("currentUser", currentDepartment);
//            request.getRequestDispatcher("/WEB-INF/editDepartment.jsp").forward(request, response);
//        } else if (uri.equals("/error")) {
//            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
//        } else {
//            response.sendRedirect("/error");
//        }
//
//    }


