package com.admin.service.impl;

import com.admin.mapper.UserMapper;
import com.admin.model.User;
import com.admin.param.UserParam;
import com.admin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public List<User> getList(UserParam userParam) {
        return userMapper.getList(userParam);
    }

    @Override
    public int getCount(UserParam userParam) {
        return userMapper.getCount(userParam);
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }
}
