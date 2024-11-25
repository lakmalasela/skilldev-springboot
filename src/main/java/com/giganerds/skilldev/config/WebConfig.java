package com.giganerds.skilldev.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF protection (useful for Postman testing)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/register").permitAll()  // Allow public access to register endpoint
                        .anyRequest().authenticated()  // All other requests require authentication
                )

                .formLogin(form -> form  // Use formLogin() without deprecated method
                        .loginPage("/login")  // Custom login page (optional, defaults to a Spring Security login page)
                        .permitAll()  // Allow public access to the login page
                )
                .httpBasic(httpBasic -> httpBasic.disable());  // Disable HTTP Basic Authentication (avoid deprecated)
//                .formLogin(withDefaults());
        return http.build();
    }
}
