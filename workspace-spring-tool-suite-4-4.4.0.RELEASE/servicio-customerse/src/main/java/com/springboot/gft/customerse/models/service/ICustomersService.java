package com.springboot.gft.customerse.models.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.gft.customerse.facade.dto.Customer;

public interface ICustomersService {

	public List<Customer> listar();
	public Customer detalle( @PathVariable Long id) ;
	public Customer crear(@RequestBody Customer cliente) ;
	public int eliminar(@PathVariable Long id);
	public Customer editar(@RequestBody Customer customer, @PathVariable Long id) ;
	
}
