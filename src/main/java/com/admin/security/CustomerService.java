package com.admin.security;

import com.admin.model.Permission;
import com.admin.model.Role;
import com.admin.model.User;
import com.admin.service.PermissionService;
import com.admin.service.RoleService;
import com.admin.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerService implements UserDetailsService {
    @Resource
    private UserService userService;
    @Resource
    private PermissionService permissionService;
    @Resource
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        AdminUser adminUser = null;
        if(user != null){
            adminUser = new AdminUser();
            adminUser.setUsername(user.getUsername());
            adminUser.setPassword(user.getPassword());
            adminUser.setId(user.getId());
            Role role = roleService.findById(user.getId());
            List<Long> ids = Arrays.stream(role.getPermissionIds().split(",")).map(Long::parseLong).collect(Collectors.toList());
            List<Permission> permissions = permissionService.findByIds(ids);
            adminUser.setPermissions(permissions);
        }
        return adminUser;
    }
}
