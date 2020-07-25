package com.lwl.quizer.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;


public class User implements Serializable {
		
		@Id
		private String id;
		private String name;
		private String email;
		
		public User() {
		}

		public User(String name, String email) {
			super();
			this.name = name;
			this.email = email;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("User [id=").append(id).append(", name=").append(name).append(", email=").append(email)
					.append("]");
			return builder.toString();
		}
		
		
		
	
}
