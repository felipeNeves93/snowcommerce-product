package com.sowcommerceproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SowcommerceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SowcommerceProductApplication.class, args);
	}

}
