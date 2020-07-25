package com.lwl.scart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.lwl.scart.domain.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "app")
public class ProductService {
	private List<Product> products;

	public Optional<Product> getProductById(String pid) {
		return products.stream().filter(p -> p.getPid().equals(pid)).findAny();
	}

}
