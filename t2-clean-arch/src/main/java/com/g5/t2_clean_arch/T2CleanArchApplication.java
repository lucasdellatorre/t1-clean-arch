package com.g5.t2_clean_arch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class T2CleanArchApplication {

	public static void main(String[] args) {
		SpringApplication.run(T2CleanArchApplication.class, args);
	}

}
