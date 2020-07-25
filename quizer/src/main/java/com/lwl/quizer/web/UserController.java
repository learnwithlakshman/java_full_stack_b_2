package com.lwl.quizer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwl.quizer.domain.User;
import com.lwl.quizer.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/byid/{userid}")
	public ResponseEntity<?> getUser(@PathVariable("userid") String id) {

		User user = userService.getUser(id);
		if (user != null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.status(404).body("User not found with given id:" + id);

	}
}
