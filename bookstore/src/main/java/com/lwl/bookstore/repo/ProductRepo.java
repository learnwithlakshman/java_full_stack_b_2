package com.lwl.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lwl.bookstore.domain.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
