package com.hejsr.daily.modules.user.config;


import com.hejsr.daily.modules.user.entity.UserEntity;
import com.hejsr.daily.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebUserConfig implements WebMvcConfigurer {

    @Autowired
    private UserService userService;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            UserEntity user = userService.getUserByUsername(username);
            if (user.getUsername() != null && !"".equals(user.getUsername())) {
                throw new UsernameNotFoundException("用户名未找到");
            }
            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            String passwordAfterEncoder = passwordEncoder.encode(user.getPassword());
            return User.withUsername(username).password(passwordAfterEncoder).roles("").build();
        };
//
    }
}