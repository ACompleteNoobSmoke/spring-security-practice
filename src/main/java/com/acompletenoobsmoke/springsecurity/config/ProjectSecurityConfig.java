package com.acompletenoobsmoke.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        System.out.println("SWAMP IZZO");
        return http.build();
    }
}