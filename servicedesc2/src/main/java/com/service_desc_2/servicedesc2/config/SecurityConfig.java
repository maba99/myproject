package com.service_desc_2.servicedesc2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Отключение CSRF для упрощения (не рекомендуется для продакшна)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/roles/**").hasRole("SUPERADMIN")
                        .requestMatchers("/employees/**").hasAnyRole("ADMIN", "SUPERADMIN")
                        .requestMatchers("/tickets/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                        .anyRequest().authenticated() // Все остальные запросы требуют аутентификации
                )
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll) // Разрешение на вход для всех пользователей
                .logout(LogoutConfigurer::permitAll);// Разрешение на выход для всех пользователей

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("superadmin").password(passwordEncoder().encode("superadmin")).roles("SUPERADMIN")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
                .and()
                .withUser("user").password(passwordEncoder().encode("user")).roles("USER");

        return authenticationManagerBuilder.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}