package com.lwl.springapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
		
		@Bean
		public Greetings greetings() {
			BirthdayGreetings obj = new BirthdayGreetings();
			obj.setMessage("Happy Birthday!....");
			obj.setSender(senderObject());
			return obj;
		}
		
		@Bean(name = "senderObj")
		public Sender senderObject() {
			return new Sender();
		}
}
