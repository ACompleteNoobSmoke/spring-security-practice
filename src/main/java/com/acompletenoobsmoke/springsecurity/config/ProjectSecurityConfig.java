package com.acompletenoobsmoke.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    private final static List<String> apiList;

    static {
        apiList = new ArrayList<>();
        apiList.add("/myAccount");
        apiList.add("/myBalance");
        apiList.add("/myCard");
        apiList.add("/myLoan");
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception {
        System.out.println(apiList);
//        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        http.authorizeHttpRequests(request -> request
                .requestMatchers(apiList.stream().toArray(String[]::new)).authenticated()
                .requestMatchers("/", "/myNotice", "/myContact", "/error").permitAll());
        http.formLogin(flc -> flc.disable());
        http.httpBasic(withDefaults());
        System.out.println("SWAMP IZZO");
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withUsername("user").password("$2a$12$irwCLh.ny8AGu.3yUEeZhu1cUcUjl7RikfUwBL8NvikrSzJidY8b2").authorities("read").build();
        UserDetails adminDetails = User.withUsername("admin").password("$2a$12$E78kKK9KoScVMmC1ZxsbZ.h4nTvPY4gmlAdIypgZwYv1oTgY49bZG").authorities("admin").build();
        return new InMemoryUserDetailsManager(userDetails, adminDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}