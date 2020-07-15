package com.lwl.iplserverapp;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lwl.iplserverapp.domain.Team;
import com.lwl.iplserverapp.repo.TeamRepo;
import com.mongodb.client.MongoClient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
class User{
	@Id
	private String id;
	private String username;
	private String password;
}

@SpringBootApplication
public class IplserverappApplication implements CommandLineRunner {

	@Autowired
	private TeamRepo teamRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(IplserverappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Team> teams = teamRepo.findAll();
		teams.forEach(team->{
			System.out.println(team.getName());
		});
	}
}
