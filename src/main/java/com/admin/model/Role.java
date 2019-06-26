package com.admin.model;

import java.io.Serializable;

public class Role implements Serializable {
    private static final long serialVersionUID = 79303075755921456L;

    private Long id;
    private String roleName;
    private String permissionIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(String permissionIds) {
        this.permissionIds = permissionIds;
    }
}
