package com.lwl.sms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(encoder);

	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
	}

}
