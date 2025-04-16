package com.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.handlers.ProductHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class ProductRouter {

	
	 @Bean
	 RouterFunction<ServerResponse> route(ProductHandler productHandler) {

	    return RouterFunctions
	      .route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), productHandler::listar);
	  }
	
}
