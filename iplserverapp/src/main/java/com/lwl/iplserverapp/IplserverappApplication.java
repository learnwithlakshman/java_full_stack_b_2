package com.lwl.iplserverapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class IplserverappApplication implements CommandLineRunner {

	@Autowired
	private MongoOperations mongoOpe;

	public static void main(String[] args) {
		SpringApplication.run(IplserverappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			
	}
}
