package com.reposotories;

import org.springframework.stereotype.Repository;

import com.models.Product;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Integer>  {

	
}
