package com.cdk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.cdk.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringBootCRUDApp extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCRUDApp.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
       return builder.sources(SpringBootCRUDApp.class);
    }
}
