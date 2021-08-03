package com.springboot.gft.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

import com.springboot.gft.clientes.config.SpringFoxConfig;

@SpringBootApplication
@EnableEurekaClient
@Import(SpringFoxConfig.class)
public class ServicioClientesApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ServicioClientesApplication.class, args);
	}

}
