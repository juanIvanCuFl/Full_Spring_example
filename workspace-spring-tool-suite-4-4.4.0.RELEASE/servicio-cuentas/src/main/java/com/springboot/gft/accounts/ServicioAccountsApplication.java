package com.springboot.gft.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServicioAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioAccountsApplication.class, args);
	}

}
