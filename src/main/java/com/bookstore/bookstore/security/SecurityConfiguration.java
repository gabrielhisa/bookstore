package com.bookstore.bookstore.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    // Adding support for the JDBC
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        // Tells the Spring Security to use the JDBC authentication with our data source
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Making is custom by defining a query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );

        // Define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/books/all").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/books/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/books/newbook").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/books/update/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.DELETE, "/books/delete/**").hasRole("ADMIN")
        );

        // Using HTTP Basic Auth
        http.httpBasic(Customizer.withDefaults());

        // Disabling CSRF, in general not needed for REST APIs
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}

