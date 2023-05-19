
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
	// users were kept from previous task but not necessary
    public UserDetailsService userDetailsService() {
        UserDetails reilly = User.withDefaultPasswordEncoder()
                .username("reilly")
                .password("hello-security")
                .roles("USER")
                .build();
        UserDetails newton = User.withDefaultPasswordEncoder()
                .username("newton")
                .password("password")
                .roles("PREMIUM_USER")
                .build();
        return new InMemoryUserDetailsManager(reilly, newton);
    }

    @Override
	protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/home/**").permitAll()
				.anyRequest().authenticated()
                .and().httpBasic();
	}
}