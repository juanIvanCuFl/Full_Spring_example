package com.springboot.gft.clientes.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.gft.clientes.models.entity.Customer;
import com.springboot.gft.clientes.models.services.ICustomerService;


@RefreshScope
@RestController
@RequestMapping("/v1")
public class CustomerController {

	@Autowired
	private ICustomerService clienteService;

	@GetMapping(value = "/")
	public List<Customer> listar(HttpServletRequest request){
		//System.out.println("Url listar: " +  request.getRequestURL().toString());
		return clienteService.findAll().stream().map((p)-> {
			p.setName(p.getName().toUpperCase());
			p.setApp(p.getApp().toUpperCase());
			return p;
		}).collect(Collectors.toList());
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity detalle(HttpServletRequest request, @PathVariable Long id) throws Exception{
		Customer cliente = clienteService.findById(id);
		
		ResponseEntity resultEntity = null;
		
		if(cliente !=null) {
			resultEntity = ResponseEntity.ok(cliente);
		}else {
			resultEntity =  ResponseEntity.notFound().build();
		}
		
		return resultEntity;

	}
	
	@PostMapping(value="/")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer crear(@RequestBody Customer cliente) {
		Customer p =  clienteService.save(cliente);
		return p;
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity eliminar(@PathVariable Long id){
		Customer cliente = clienteService.findById(id);
		if(cliente == null) {
			return  ResponseEntity.notFound().build();
		}else {
			clienteService.deleteById(id);
			return  ResponseEntity.ok().build();
		}
		
		
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Customer editar(@RequestBody Customer customer, @PathVariable Long id) {
		return clienteService.save(customer);
	}
	
	
}
