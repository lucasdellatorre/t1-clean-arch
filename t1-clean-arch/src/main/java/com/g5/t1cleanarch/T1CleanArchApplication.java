package com.g5.t1cleanarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.g5.t1cleanarch"})
@SpringBootApplication
public class T1CleanArchApplication {

	public static void main(String[] args) {
		SpringApplication.run(T1CleanArchApplication.class, args);
	}

}
