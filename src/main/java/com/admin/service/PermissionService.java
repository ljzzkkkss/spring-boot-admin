package com.admin.service;

import com.admin.model.Permission;
import com.admin.param.PermissionParam;

import java.util.List;


public interface PermissionService {
    Permission findById(Long id);
    List<Permission> findByIds(List<Long> ids);
    List<Permission> getList(PermissionParam permissionParam);
    int getCount(PermissionParam permissionParam);
    void insert(Permission permission);
    void update(Permission permission);
    void delete(Long id);
}
