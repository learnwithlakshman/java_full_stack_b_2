package com.lwl.iplserverapp;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lwl.iplserverapp.service.TeamService;
import com.lwl.iplserverapp.service.TeamServiceImpl;




@SpringBootApplication
public class IplserverappApplication  {

	public static void main(String[] args) {
		 SpringApplication.run(IplserverappApplication.class, args);
	
				 
	
	}

	@Bean
	public TeamService teamService() {
		return new TeamServiceImpl();
	}
}
