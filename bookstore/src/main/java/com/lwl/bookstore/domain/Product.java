package com.lwl.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int pid;
		private String pname;
		private double price;
		
		
}
