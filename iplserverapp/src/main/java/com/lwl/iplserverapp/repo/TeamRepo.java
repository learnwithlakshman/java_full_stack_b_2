package com.lwl.iplserverapp.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lwl.iplserverapp.domain.Team;

public interface TeamRepo extends MongoRepository<Team,String> {
	List<Team> findByNameLike(String str);
}
