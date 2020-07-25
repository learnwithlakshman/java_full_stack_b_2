package com.lwl.quizer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lwl.quizer.domain.User;
import com.lwl.quizer.repo.UserRepo;
import com.lwl.quizer.service.UserService;

@SpringBootApplication
public class QuizerApplication implements CommandLineRunner {

	@Value("${message}")
	private String message;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(QuizerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		User user = userService.getUser("5f17a84f790fe139bce54924");
//			System.out.println(user);

//			userRepo.deleteAll();
//			List<User> list = Stream.of(new User("Krish", "krish@gmail.com"),new User("Rajesh","rajesh@gmail.com"),new User("manoj", "manoj@gmail.com"),new User("Charan", "charan@gmail.com"))
//				.collect(Collectors.toList());
//			
//			list = userRepo.saveAll(list);
//			list.stream().forEach(e->{
//				System.out.println(e);
//			});
	}
}
