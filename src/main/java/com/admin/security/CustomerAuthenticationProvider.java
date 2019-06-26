package com.admin.security;

import com.admin.utils.MD5Util;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;

@Component
public class CustomerAuthenticationProvider implements AuthenticationProvider {
    @Resource
    private CustomerService customerService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();//获取表单中输入返回的用户名
        String password = (String) authentication.getCredentials();//获取表单中返回的密码;

        AdminUser adminUser = (AdminUser) customerService.loadUserByUsername(username);

        if(adminUser == null){
            throw new BadCredentialsException("用户名错误！");
        }

        if(!MD5Util.md5(password).equals(adminUser.getPassword())){
            throw new BadCredentialsException("密码错误！");
        }

        Collection<? extends GrantedAuthority> authorities = adminUser.getAuthorities();
        return new UsernamePasswordAuthenticationToken(adminUser, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
