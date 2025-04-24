package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
public class DbConfig extends AbstractR2dbcConfiguration {

	
	@Value("${spring.r2dbc.url}")
	private String dbUrl;
	
	
	@Override
	public ConnectionFactory connectionFactory() {
		// TODO Auto-generated method stub
		return ConnectionFactories.get(dbUrl);
	}

	
	@Bean
	ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
		
		ConnectionFactoryInitializer i = new ConnectionFactoryInitializer();
		i.setConnectionFactory(connectionFactory);
		return i;
		
	}
	
	
}
