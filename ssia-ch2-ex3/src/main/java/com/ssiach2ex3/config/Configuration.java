package com.ssiach2ex3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(c -> c.anyRequest().permitAll());
        return http.build();
    }
}
