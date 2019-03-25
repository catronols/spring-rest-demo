package com.ols;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class SpringRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestDemoApplication.class, args);
	}

	@Bean
	public KeycloakConfigResolver KeycloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}

}
