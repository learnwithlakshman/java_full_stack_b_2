package com.lwl.iplserverapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class IplserverappApplication implements CommandLineRunner {
	
	private Logger log = LoggerFactory.getLogger(IplserverappApplication.class);
	@Autowired
	private MongoOperations mongoOpe;

	public static void main(String[] args) {
		SpringApplication.run(IplserverappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}
}
