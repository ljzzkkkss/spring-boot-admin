package com.admin.service.impl;

import com.admin.mapper.RoleMapper;
import com.admin.model.Role;
import com.admin.param.RoleParam;
import com.admin.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public Role findById(Long id) {
        return roleMapper.findById(id);
    }

    @Override
    public List<Role> getList(RoleParam roleParam) {
        return roleMapper.getList(roleParam);
    }

    @Override
    public int getCount(RoleParam roleParam) {
        return roleMapper.getCount(roleParam);
    }

    @Override
    public void insert(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void update(Role role) {
        roleMapper.update(role);
    }

    @Override
    public void delete(Long id) {
        roleMapper.delete(id);
    }
}
