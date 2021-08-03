package com.springboot.gft.customerse.facade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.springboot.gft.customerse.facade.dto.Customer;
import com.springboot.gft.customerse.models.service.ICustomersService;

@RefreshScope
@RestController
@RequestMapping("/v1")
public class CustomerseController {

	@Autowired
	@Qualifier("service-feign")
	private ICustomersService clienteService;
	

	@GetMapping(value = "/")
	public List<Customer> listar(HttpServletRequest request){
		//System.out.println("Url listar: " +  request.getRequestURL().toString());
		return clienteService.listar();
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity detalle(HttpServletRequest request, @PathVariable Long id) throws Exception{
		Customer result = clienteService.detalle(id);
		if(result != null) {
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@PostMapping(value="/")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer crear(@RequestBody Customer cliente) {
		return clienteService.crear(cliente);
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity eliminar(@PathVariable Long id){
		 int result = clienteService.eliminar(id);
		 if(result == 204)
			 return ResponseEntity.noContent().build();
		 else if(result == 404)
			 return ResponseEntity.notFound().build();
		 else
			 return ResponseEntity.badRequest().build();
		
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Customer editar(@RequestBody Customer customer, @PathVariable Long id) {
		return clienteService.editar(customer, id);
	}
	
	
	
}
