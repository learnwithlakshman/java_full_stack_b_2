package com.lwl.bookstore.service;

import java.util.List;

import com.lwl.bookstore.domain.Product;

public interface ProductService {

		public List<Product> getProductList();

		public Product getProductById(int pid);
}
