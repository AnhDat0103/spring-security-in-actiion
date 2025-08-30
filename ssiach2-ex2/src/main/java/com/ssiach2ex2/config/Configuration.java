package com.ssiach2ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    UserDetailsService userDetailsService(){
        var user = User.builder()
                .username("trongdat")
                .password("1234")
                .authorities("read")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance(); // bo qua viec hasing, encrypt password
    }
}
