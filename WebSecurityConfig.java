package com.hackerrank.springsecurity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.springsecurity.dto.ApiResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override  // Below two methods were correct before adding last two classes to pass last 3 tests.
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("john_doe")
                .password("{noop}student_password")
                .authorities("ROLE_STUDENT_USER")
                .and()
                .withUser("jane_doe")
                .password("{noop}admin_password")
                .authorities("ROLE_OFFICE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf().disable()
                .authorizeRequests()
                .mvcMatchers(HttpMethod.POST, "/course").hasRole("OFFICE_ADMIN")
                .mvcMatchers(HttpMethod.POST, "/student").hasAnyRole("STUDENT_USER", "OFFICE_ADMIN")
                .anyRequest().permitAll()
                .and()
				// I needed to add Basic authorization and custom exception handler below as HR support told me
                .httpBasic()
                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new CustomAccessDeniedHandler());  // create exception handler below

    }

    public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
        ObjectMapper mapper = new ObjectMapper();

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException {
			// Output values given in problem statement.
            ApiResponse apiResponse = new ApiResponse(HttpStatus.UNAUTHORIZED.value(), "Authentication Failure-The user name and password combination is incorrect");
            response.setContentType("application/json");
            response.getOutputStream().println(mapper.writeValueAsString(apiResponse));
        }
    }

	// Had to look up AccessDeniedHandler and got much of this later but only one line not easy. HR support gave some hints on this method along with lots of research.
    public class CustomAccessDeniedHandler implements AccessDeniedHandler {
        ObjectMapper mapper = new ObjectMapper();

        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exc) throws IOException {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();  // didn't know much about SecurityContextHolder so took a long time
			
			// if auth == null there are other problems but not authorization. Output values given in problem statement.
            if (auth != null) {
                ApiResponse apiResponse = new ApiResponse(HttpStatus.FORBIDDEN.value(), "Authorization Failure-This user does not have the sufficient level of access");
                response.setContentType("application/json");
                response.getOutputStream().println(mapper.writeValueAsString(apiResponse));
            }
        }
    }
}
