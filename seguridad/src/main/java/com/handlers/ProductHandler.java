package com.handlers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.models.Product;

import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

	  public Mono<ServerResponse> listar(ServerRequest request) {
		    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
		      .body(BodyInserters.fromValue(List.of( new Product(1, "Hello, Spring!"), new Product(1, "Hello, Spring!"))));
		  }
	
}
