package com.lwl.quizer.service;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lwl.quizer.domain.User;
import com.lwl.quizer.repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	CacheManager cacheManager;
	
	@Cacheable(value = "user-cache",key ="#id")
	public User getUser(String id) {
		
		
		Cache<String, User> cache = cacheManager.getCache("user-cache", String.class, User.class);
		if(cache.get(id)!=null) {
			return cache.get(id);
		}
		
		Optional<User> optUser = userRepo.findById(id);
		
		if (optUser.isPresent()) {
			User user = optUser.get();
			cache.putIfAbsent(id, user);
			return user;
		}
	
	
		return null;
	}
	
	
	public List<User> getUsers() {
		
		return userRepo.findAll();
	}

}
