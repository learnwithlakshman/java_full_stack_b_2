package com.lwl.sms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class AppConfig {

		@Bean
		public BCryptPasswordEncoder encoder() {
			return new BCryptPasswordEncoder();
		}
}
