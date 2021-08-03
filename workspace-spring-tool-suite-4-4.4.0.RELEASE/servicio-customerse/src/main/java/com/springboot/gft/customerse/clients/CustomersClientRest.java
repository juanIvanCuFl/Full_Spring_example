package com.springboot.gft.customerse.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springboot.gft.customerse.facade.dto.Customer;

@FeignClient(name = "servicio-customers")
public interface CustomersClientRest {

	@GetMapping(value = "/customers/v1/")
	public List<Customer> listar();
	
	
	@GetMapping(value = "/customers/v1/{id}")
	public Customer detalle( @PathVariable Long id) ;
	
	@PostMapping(value="/customers/v1/")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer crear(@RequestBody Customer cliente) ;
	
	@DeleteMapping(value = "/customers/v1/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id);
	
	@PutMapping(value = "/customers/v1/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Customer editar(@RequestBody Customer customer, @PathVariable Long id) ;
	
}
