package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Product;
import com.reposotories.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository repo;
	
	
	public Flux<Product> getAll(){
		return repo.findAll();
	}
	
	
	public Mono<Product> getById(int id){
		return repo.findById(id);
	}
	
	
	public Mono<Product> save(Product product){	
		return repo.save(product);
	}
	
	
    public Mono<Product> update(int id, Product product){		
		return repo.save(new Product(id, product.getProductName()));
	}
   
     
    public Mono<Void> delete(int id){
 		return repo.deleteById(id);
 	}
    
}
