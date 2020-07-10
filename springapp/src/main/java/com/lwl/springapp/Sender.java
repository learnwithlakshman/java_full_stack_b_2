package com.lwl.springapp;

import org.springframework.stereotype.Component;

@Component
public class Sender {

		public void sendMessage(String message) {
			System.out.println("Greetings will be send : with message { "+message+" }");
		}
}
