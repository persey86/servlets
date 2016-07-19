package com.devcolibri.servlet.dao;


import com.devcolibri.servlet.entities.User;

import java.util.Date;
import java.util.List;

/**
 * Created by Anastasia on 11.06.2016.
 */
public interface UserRepository {
    List<User> getUsers();

    User saveUser(String userName, String userSurname, Date created, Integer departmentId);
}
