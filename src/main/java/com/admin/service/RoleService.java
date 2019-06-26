package com.admin.service;

import com.admin.model.Role;
import com.admin.param.RoleParam;

import java.util.List;


public interface RoleService {
    Role findById(Long id);
    List<Role> getList(RoleParam roleParam);
    int getCount(RoleParam roleParam);
    void insert(Role role);
    void update(Role role);
    void delete(Long id);
}
