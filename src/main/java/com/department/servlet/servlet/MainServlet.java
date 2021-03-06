package com.department.servlet.servlet;

import com.department.servlet.dao.impl.DepartmentRepository;
import com.department.servlet.dao.impl.UserRepository;
import com.department.servlet.entities.Department;
import com.department.servlet.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created on 31.03.17.
 */
public class MainServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserRepository userRepository = new UserRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();


        String uri = request.getRequestURI();
        String method = request.getMethod();

        if (uri.contains("/users/departmentId") && method.equals("GET")) {
            String[] urlParams = uri.split("/");
            String departmentId = urlParams[urlParams.length - 1];
            Integer departmentIdInt = Integer.parseInt(departmentId);

            List<User> users = userRepository.getUsersByDepartmentId(departmentIdInt);

            Department departmentById = departmentRepository.getDepartmentById(departmentIdInt);

            List<Department> departments = departmentRepository.getDepartments();

            request.setAttribute("users", users);
            request.setAttribute("departmentById", departmentById);
            request.setAttribute("departments", departments);
            request.getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        }


        if (uri.contains("/department/edit/") && method.equals("GET")) {
            String[] urlParams = uri.split("/");
            String departmentId = urlParams[urlParams.length - 1];
            Integer departmentIdInt = Integer.parseInt(departmentId);


            Department currentDepartment = departmentRepository.getDepartmentById(departmentIdInt);

            request.setAttribute("currentDepartment", currentDepartment);
            request.getRequestDispatcher("/WEB-INF/editDepartment.jsp").forward(request, response);
        }


        if (uri.equals("/") && method.equals("GET")) {
            List<User> users = userRepository.getUsers();
            List<Department> departments = departmentRepository.getDepartments();
            request.setAttribute("users", users);
            request.setAttribute("departments", departments);
            request.getRequestDispatcher("/WEB-INF/mypage.jsp").forward(request, response);
        }

        if (uri.equals("/users") && method.equals("POST")) {

            // general functionality for add use and update user
            String id = request.getParameter("id");
            String userName = request.getParameter("userName");
            String userSurname = request.getParameter("userSurname");
            String userEmail = request.getParameter("userEmail");
            String departmentId = request.getParameter("departmentId");
            String date = request.getParameter("userDate");
            String age = request.getParameter("userAge");

            boolean departmentIdeValid = departmentId.matches("(?<=\\s|^)\\d+(?=\\s|$)");
            boolean userEmailValid = userEmail.matches("^[a-z0-9_\\-\\.]{2,}@[a-z0-9_\\-\\.]{2,}\\.[a-z]{2,}$");


            if (departmentIdeValid && userEmailValid) {
                Integer departmentIdInt = Integer.parseInt(departmentId);
                Integer ageInt = Integer.parseInt(age);


                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                Date dateType = new Date();

                try {
                    dateType = simpleDateFormat.parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }


                if (id == null) {

                    // if there is no id we create new user
                    User userByEmail = userRepository.getUserByEmail(userEmail);
                    if (userByEmail == null) {
                        userRepository.saveUser(userName, userSurname, userEmail, dateType, departmentIdInt, ageInt);

                    }
                    response.sendRedirect("/users/departmentId/" + departmentId);



                } else {

                    // if id is not null we update user
                    Integer idInt = Integer.parseInt(id);
                    User userByEmailNotID = userRepository.getUserByEmailNotID(idInt, userEmail);
                    if (userByEmailNotID==null) {
                        userRepository.updateUser(idInt, userName, userSurname, userEmail, dateType, departmentIdInt, ageInt);
                        response.sendRedirect("/users/departmentId/" + departmentId);
                    }else{
                        response.sendRedirect("/user/edit/" + id);
                    }


                }

            } else {
                if (id != null) {
                    response.sendRedirect("/user/edit/" + id);
                } else {
                    response.sendRedirect("/users/departmentId/" + departmentId);
                }

            }

        }

        if (uri.equals("/user/delete") && method.equals("POST")) {
            String userId = request.getParameter("departmentId");
            Integer userIdInt = Integer.parseInt(userId);
            userRepository.deleteUser(userIdInt);
            response.sendRedirect("/");
        }


        /// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (uri.contains("/user/edit/") && method.equals("GET")) {
            String[] urlParams = uri.split("/");
            String userId = urlParams[urlParams.length - 1];
// is id number
            boolean matches = userId.matches("(?<=\\s|^)\\d+(?=\\s|$)");

            if (matches) {
                Integer userIdInt = Integer.parseInt(userId);

                User currentUser = userRepository.getUserById(userIdInt);

                request.setAttribute("currentUser", currentUser);
                request.getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
            } else {
                response.sendRedirect("/error");
            }


        }

        if (uri.equals("/error")) {
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }


        //here we creates new department
        if (uri.equals("/departments") && method.equals("POST")) {

            String name = request.getParameter("departmentName");
            String id = request.getParameter("id");
            departmentRepository.saveDepartment(name, new Date());
            response.sendRedirect("/");
        }

        if (uri.equals("/department/delete") && method.equals("POST")) {
            String id = request.getParameter("departmentId");
            Integer idInt = Integer.parseInt(id);
            departmentRepository.deleteDepartment(idInt);
            response.sendRedirect("/");
        }


    }
}
