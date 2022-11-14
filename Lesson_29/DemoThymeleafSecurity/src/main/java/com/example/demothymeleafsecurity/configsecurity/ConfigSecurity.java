package com.example.demothymeleafsecurity.configsecurity;

import com.example.demothymeleafsecurity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginService loginService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home", "/css/**").permitAll()
                .antMatchers("/category/**").hasAnyAuthority("EMPLOYEE", "ADMIN")
                .antMatchers("/admin/save").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin();
    }
}
