package com.admin.model;

import java.io.Serializable;

public class Permission implements Serializable {
    private static final long serialVersionUID = -3793743407415029688L;

    private Long id;
    private String permissionName;
    private String uri;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
