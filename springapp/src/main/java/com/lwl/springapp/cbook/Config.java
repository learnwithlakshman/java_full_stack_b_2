package com.lwl.springapp.cbook;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ljava.cbook.service.ContactService;
import com.ljava.cbook.service.ContactServiceImpl;



@Configuration
@ComponentScan(basePackages = {"com.lwl.springapp.cbook","com.cj.pj"})
public class Config {
	
		@Bean
		@Scope(value = "singleton")
		public ContactService contactService() {
			return new ContactServiceImpl();
		}
		
}
