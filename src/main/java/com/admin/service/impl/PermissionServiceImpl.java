package com.admin.service.impl;

import com.admin.mapper.PermissionMapper;
import com.admin.model.Permission;
import com.admin.model.User;
import com.admin.param.PermissionParam;
import com.admin.param.UserParam;
import com.admin.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public Permission findById(Long id) {
        return permissionMapper.findById(id);
    }

    @Override
    public List<Permission> findByIds(List<Long> ids) {
        return permissionMapper.findByIds(ids);
    }

    @Override
    public List<Permission> getList(PermissionParam permissionParam) {
        return permissionMapper.getList(permissionParam);
    }

    @Override
    public int getCount(PermissionParam permissionParam) {
        return permissionMapper.getCount(permissionParam);
    }

    @Override
    public void insert(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Override
    public void update(Permission permission) {
        permissionMapper.update(permission);
    }

    @Override
    public void delete(Long id) {
        permissionMapper.delete(id);
    }
}
