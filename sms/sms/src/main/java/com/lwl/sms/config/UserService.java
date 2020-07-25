package com.lwl.sms.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	private BCryptPasswordEncoder encoder;

	private Map<String, UserDetails> map = new HashMap<>();

	@Autowired
	public UserService(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
		map.put("user@gmail.com",
				User.builder().username("user@gmail.com").password(encoder.encode("user")).roles("USER").build());
		map.put("admin@gmail.com",
				User.builder().username("admin@gmail.com").password(encoder.encode("admin")).roles("ADMIN").build());
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return Optional.of(map.get(username))
				.orElseThrow(() -> new UsernameNotFoundException("User details are not found"));
	}

}
