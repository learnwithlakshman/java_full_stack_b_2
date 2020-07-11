package com.lwl.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;


@Setter
@Component
public class BirthdayGreetings implements Greetings {
	
	private String message="Wish you happy Birthday";
	
	@Autowired
	private Sender sender;
	
	
	
	public void sendMessage() {
		sender.sendMessage(message);
	}


}
