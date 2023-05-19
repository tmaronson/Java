
package com.hackerrank.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.http.HttpMethod;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
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
		 //.sessionManagement()
          //.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		      .authorizeRequests()
          .antMatchers(HttpMethod.GET, "/course/**").permitAll()
          .antMatchers(HttpMethod.POST, "/course/**").hasRole("OFFICE_ADMIN")
          .antMatchers("student/**").hasAnyRole("OFFICE_ADMIN", "STUDENT_USER")
          .and().csrf().disable();
          http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 
		 /* Ignore exception handling below and start with two overloaded configure() methods above. I was just playing with exceptions below.
		 http
			.exceptionHandling()
			.authenticationEntryPoint((request, response, e) -> 
			{
				response.setContentType("application/json;charset=UTF-8");
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.getWriter().write(new JSONObject() 
					.put("timestamp", LocalDateTime.now())
					.put("message", "Authorization Failure-This user does not have the sufficient level of access")
					.toString());
		});
		
		http
			.exceptionHandling()
			.authenticationEntryPoint((request, response, e) -> 
			{
				response.setContentType("application/json;charset=UTF-8");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write(new JSONObject() 
					.put("timestamp", LocalDateTime.now())
					.put("message", "Authentication Failure-The user name and password combination is incorrect")
					.toString());
		});
		*/
        
       
    }

}
