package com.admin.config;

import com.admin.security.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Resource
    private CustomerAuthenticationProvider customerAuthenticationProvider;
    @Resource
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Resource
    private AuthenticationFailHandler authenticationFailHandler;
    @Resource
    private CustomerAuthenticationEntryPoint customerAuthenticationEntryPoint;
    @Resource
    private AuthenticationLogoutSuccessHandler authenticationLogoutSuccessHandler;
    @Resource
    private NoAuthenticationHandler noAuthenticationHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customerAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .httpBasic().authenticationEntryPoint(customerAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/v2/api-docs","/swagger-resources","/swagger-resources/**","/swagger-ui.html","/webjars/**","/success","/loginFail","/regist","/needLogin","/noPermission","/error")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(authenticationLogoutSuccessHandler)
                .permitAll()
                .and()
                .sessionManagement()
                .maximumSessions(1);

        http.exceptionHandling().accessDeniedHandler(noAuthenticationHandler);
    }

}
