package com.admin.service;

import com.admin.model.User;
import com.admin.param.UserParam;

import java.util.List;


public interface UserService {
    User findByUsername(String username);
    List<User> getList(UserParam userParam);
    int getCount(UserParam userParam);
    void insert(User user);
    void update(User user);
    void delete(Long id);
}
