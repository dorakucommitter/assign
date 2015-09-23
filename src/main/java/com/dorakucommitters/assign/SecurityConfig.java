/*
 */
package com.dorakucommitters.assign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.dorakucommitters.assign.service.LoginEmployeeDetailsService;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.authorizeRequests()
        		.antMatchers("/webjars/**", "/javascript/**").permitAll()
        		.anyRequest().authenticated()
        		.and()
        	.csrf()
        		.disable()
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
        LoginEmployeeDetailsService employeeDetailsService;

        @Bean
        PasswordEncoder passwordEncoder() {
            // PasswordEncoder encoder = new LdapShaPasswordEncoder ();
            return new BCryptPasswordEncoder();
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(this.employeeDetailsService)
                .passwordEncoder(passwordEncoder());
        }
    }
}
