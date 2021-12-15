package com.admin.config;

import com.admin.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
    CustomizeSessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(customerAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/v2/api-docs","/swagger-resources","/swagger-resources/**","/swagger-ui.html","/webjars/**","/success","/loginFail","/regist","/needLogin","/noPermission","/error")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .logout()
                .logoutSuccessHandler(authenticationLogoutSuccessHandler)
                .permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailHandler)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(customerAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .maximumSessions(1)
                .expiredSessionStrategy(sessionInformationExpiredStrategy);
        http.addFilterAt(customizeAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    //自定义登录过滤器使用json传参
    @Bean
    CustomizeAuthenticationFilter customizeAuthenticationFilter() throws Exception {
        CustomizeAuthenticationFilter filter = new CustomizeAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(authenticationFailHandler);
        filter.setFilterProcessesUrl("/login");

        //这句很关键，重用WebSecurityConfigurerAdapter配置的AuthenticationManager，不然要自己组装AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

}
