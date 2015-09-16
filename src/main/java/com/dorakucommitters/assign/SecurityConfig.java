/*
 */
package com.dorakucommitters.assign;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.dorakucommitters.assign.domain.Employee;
import com.dorakucommitters.assign.service.EmployeeService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.authorizeRequests()
        		.antMatchers("/webjars/**").permitAll()
        		.anyRequest().authenticated()
        		.and()
        	.formLogin()
        		.loginPage("/assign/login")
        		.permitAll()
        		.and()
        	.logout()
        		.logoutRequestMatcher(new AntPathRequestMatcher("/assign/logout"))
                .logoutSuccessUrl("/assign/login")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll();
        }

    @Configuration
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

    	@Autowired
    	EmployeeService employeeService;


    	@Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {

        	List<Employee> employees = employeeService.findAll();
        	for (Employee emp : employees) {
        		auth.inMemoryAuthentication().withUser(emp.getUser_id()).password(emp.getPassword()).roles("USER");
        	}
        }
    }
}
