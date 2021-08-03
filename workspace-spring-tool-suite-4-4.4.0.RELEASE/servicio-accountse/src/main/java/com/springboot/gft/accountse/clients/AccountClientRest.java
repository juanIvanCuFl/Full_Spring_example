package com.springboot.gft.accountse.clients;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.springboot.gft.accountse.facade.dto.DtoAccount;

@FeignClient(name = "servicio-accounts")
public interface AccountClientRest {

	@GetMapping(value = "/accounts/v1/")
	public List<DtoAccount> listar();
	
	@PostMapping(value="/accounts/v1/")
	@ResponseStatus(HttpStatus.CREATED)
	public DtoAccount crear(@RequestBody DtoAccount dtoAccount) ;
	
	@GetMapping(value = "/accounts/v1/{accountNumber}/customers/{id_customer}")
	public DtoAccount detalle( @PathVariable("id_customer") Long id,
			@PathVariable("accountNumber") String accountNumber) ;
	
	@DeleteMapping(value = "/accounts/v1/{accountNumber}/customers/{id_customer}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable("id_customer") Long id,
			@PathVariable("accountNumber") String accountNumber);
	
	@PutMapping(value = "/accounts/v1/{accountNumber}/customers/{id_customer}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public DtoAccount editar(@RequestBody DtoAccount dtoAccount, @PathVariable("id_customer") Long id,
			@PathVariable("accountNumber") String accountNumber) ;
}
