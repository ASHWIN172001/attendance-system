package com.attendance.attendance_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // allow all requests without authentication
                )
                .csrf(csrf -> csrf.disable()) // explicitly disable CSRF in newer syntax
                .httpBasic(Customizer.withDefaults()); // optional: enables basic auth for future testing

        return http.build();
    }
}

