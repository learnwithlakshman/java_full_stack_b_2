package com.lwl.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwl.bookstore.domain.Product;
import com.lwl.bookstore.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public List<Product> getProductList() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(int pid) {
		Optional<Product> optProduct = productRepo.findById(pid);
		if (optProduct.isPresent()) {
			return optProduct.get();
		}
		throw null;
	}

}
