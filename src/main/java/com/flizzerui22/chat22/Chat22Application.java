package com.flizzerui22.chat22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Chat22Application {

	public static void main(String[] args) {
		SpringApplication.run(Chat22Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("*")
						.allowedOrigins("https://flizzer-lakshmanan-ui.herokuapp.com","http://localhost:4200")
						.allowedMethods("GET", "POST")
						.allowedHeaders("Origin", "Accept", "Content-Type");
			}
		};
	}

}
