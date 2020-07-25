package com.lwl.sms.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

		@RequestMapping("/")
		public String message() {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return "Welcome to Spring world :"+user.getUsername();
		}
		
}
