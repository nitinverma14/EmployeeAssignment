package com.emp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
public class SpringBootJwtApplication {
	
	static final Logger log = 
	        LoggerFactory.getLogger(SpringBootJwtApplication.class);
	

	public static void main(String[] args) {
		log.info("Before Starting application");
		
		SpringApplication.run(SpringBootJwtApplication.class, args);
	    log.info("Starting my application with {} args.", args.length);  
	}
	
	/*@Bean
	  public Docket api() {
	
	return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.emp.controller")).build();
	
	}*/

}
