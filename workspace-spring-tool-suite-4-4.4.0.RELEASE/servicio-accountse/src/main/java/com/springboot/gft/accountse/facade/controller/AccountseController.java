package com.springboot.gft.accountse.facade.controller;

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

import com.springboot.gft.accountse.facade.dto.DtoAccount;
import com.springboot.gft.accountse.models.service.IAccountService;

@RefreshScope
@RestController
@RequestMapping("/v1")
public class AccountseController {
	
	@Autowired
	@Qualifier("serviceFeign")
	private IAccountService accountService;

	@GetMapping(value = "/")
	public List<DtoAccount> listar(HttpServletRequest request){
		return accountService.listar();
	}
	
	
	@PostMapping(value="/")
	@ResponseStatus(HttpStatus.CREATED)
	public DtoAccount crear(@RequestBody DtoAccount dtoAccount) {
		DtoAccount resultAccount =  accountService.crear(dtoAccount);
		return resultAccount;
	}
	
	
	
	
	@GetMapping(value = "/{accountNumber}/customers/{id_customer}")
	public ResponseEntity detalle(HttpServletRequest request, @PathVariable("id_customer") Long id,
			@PathVariable("accountNumber") String accountNumber) throws Exception{
		
		DtoAccount result = accountService.detalle(id,accountNumber);

		if(result != null) {
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@DeleteMapping(value = "/{accountNumber}/customers/{id_customer}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity eliminar(@PathVariable("id_customer") Long id,
			@PathVariable("accountNumber") String accountNumber){
	
		 int result = accountService.eliminar(id, accountNumber);
		 
		 if(result == 204)
			 return ResponseEntity.noContent().build();
		 else if(result == 404)
			 return ResponseEntity.notFound().build();
		 else
			 return ResponseEntity.badRequest().build();
	}
	
	@PutMapping(value = "/{accountNumber}/customers/{id_customer}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public DtoAccount editar(@RequestBody DtoAccount dtoAccount, @PathVariable("id_customer") Long id,
			@PathVariable("accountNumber") String accountNumber) {
		return accountService.editar(dtoAccount, id, accountNumber);
	}
	
}
