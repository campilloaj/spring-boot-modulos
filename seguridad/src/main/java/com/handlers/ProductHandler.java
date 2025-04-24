package com.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.models.Product;

import com.services.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {
	
	@Autowired
	private ProductService productService;

	  public Mono<ServerResponse> get(ServerRequest request) {
		  
		  Flux<Product> productsFlux = productService.getAll();
		  
		  return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
		      .body(productsFlux, Product.class);
	   }
	  
       public Mono<ServerResponse> getOne(ServerRequest request) {
		  
    	    int id =  Integer.parseInt(request.pathVariable("id")); 
    	   
		    Mono<Product> product = productService.getById(id);
		 
		    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
		      .body(product, Product.class);
	   }
	  
	  
       public Mono<ServerResponse> save(ServerRequest request) {
		  
    	    Mono<Product> productMono = request.bodyToMono(Product.class);
    	    
		
		    return productMono.flatMap(x -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(productService.save(x), Product.class));
	   }
	   
       
       public Mono<ServerResponse> update(ServerRequest request) {
 		  
    	   int id =  Integer.parseInt(request.pathVariable("id")); 
    	   
     	   Mono<Product> productMono = request.bodyToMono(Product.class);
     	   
 		   return productMono.flatMap(x -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(productService.update(id, x), Product.class));
 	   }
 	   

       public Mono<ServerResponse> delete(ServerRequest request) {
 		  
     	  int id =  Integer.parseInt(request.pathVariable("id")); 
     	   
 		  //BodyInserters.fromValue(List.of( new Product(1, "Hello, Spring!"), new Product(1, "Hello, Spring!"))
 		    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
 		      .body(productService.delete(id), Product.class);
 	   }
       
}
