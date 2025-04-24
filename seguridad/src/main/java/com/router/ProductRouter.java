package com.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.handlers.ProductHandler;


@Configuration(proxyBeanMethods = false)
public class ProductRouter {

    
	 @Bean
	 RouterFunction<ServerResponse> route(ProductHandler productHandler) {

	    return RouterFunctions
	      .route()
	      .GET("/product", productHandler::get)
	      .GET("/product" + "/{id}", productHandler::getOne)
	      .POST("/product", productHandler::save)
	      .PUT("/product" + "/{id}", productHandler::update)
	      .DELETE("/product" + "/{id}", productHandler::delete)
	      .build();
	  }
	
}
