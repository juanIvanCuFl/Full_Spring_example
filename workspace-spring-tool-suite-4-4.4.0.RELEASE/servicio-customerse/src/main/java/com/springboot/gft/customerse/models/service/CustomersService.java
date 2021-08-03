package com.springboot.gft.customerse.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.gft.customerse.clients.CustomersClientRest;
import com.springboot.gft.customerse.facade.dto.Customer;

import feign.FeignException;

@Service
@Qualifier("service-feign")
public class CustomersService implements ICustomersService{

	@Autowired
	private CustomersClientRest clientRest;
	
	
	@Override
	public List<Customer> listar() {
		return clientRest.listar();
	}

	@Override
	public Customer detalle(Long id) {
		try {
			return clientRest.detalle(id);
		}catch (FeignException e) {
			if(e.status() == 404) {
				return null;
			}else {
				throw e;
			}
		}
	}

	@Override
	public Customer crear(Customer cliente) {
		return clientRest.crear(cliente);
	}

	@Override
	public int eliminar(Long id) {
		try {
		 clientRest.eliminar(id);
		 return 204;
		}catch (FeignException e) {
			if(e.status() == 404) {
				return 404;
			}else {
				throw e;
			}
		}
	}

	@Override
	public Customer editar(Customer customer, Long id) {
		return clientRest.editar(customer, id);
	}

}
