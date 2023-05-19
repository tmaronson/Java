
package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails teacher = User.withDefaultPasswordEncoder()
                .username("teacher")
                .password("teacher")
                .roles("TEACHER")
                .build();
        UserDetails student = User.withDefaultPasswordEncoder()
                .username("student")
                .password("student")
                .roles("STUDENT")
                .build();
        return new InMemoryUserDetailsManager(teacher, student);
    }

    @Override
	protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/home/**").permitAll()
				.anyRequest().authenticated()
                .and().httpBasic();
	} 
}