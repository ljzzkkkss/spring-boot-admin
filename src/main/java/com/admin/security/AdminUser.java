package com.admin.security;

import com.admin.model.Permission;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * spring boot security 用的user类
 */
public class AdminUser implements UserDetails {
    private static final long serialVersionUID = 8013745049400697368L;
    private String username;
    private Long id;
    private String password;
    private List<Permission> permissions;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Permission permission : permissions){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + permission.getPermissionName().toUpperCase()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {//账户是否过期
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {//账户是否被锁定
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {//账户密码是否过期
        return true;
    }

    @Override
    public boolean isEnabled() {//账户是否可用
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
