package com.ktx.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.ktx")
@EnableJpaRepositories("com.ktx.repo")
@EntityScan("com.ktx.persistence.model")
public class KtxRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KtxRestApiApplication.class, args);
	}
}
