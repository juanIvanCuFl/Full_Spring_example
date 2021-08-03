package com.springboot.gft.accounts.facade.controller;

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

import com.springboot.gft.accounts.facade.dto.DtoAccount;
import com.springboot.gft.accounts.models.entity.Account;
import com.springboot.gft.accounts.models.entity.Account_pk;
import com.springboot.gft.accounts.models.service.IAccountService;

@RefreshScope
@RestController
@RequestMapping("/v1")
public class AccountController {

	@Autowired
	private IAccountService accountService;

	@GetMapping(value = "/")
	public List<DtoAccount> listar(HttpServletRequest request){
		return accountService.findAll().stream().map(
				(p) -> { return new DtoAccount(p.getAccountPk().getIdCustomer(), 
						p.getAccountPk().getAccountNumber(), 
						p.getSaldo(), p.getProductType());	
						}).collect(Collectors.toList());
	}
	
	
	@PostMapping(value="/")
	@ResponseStatus(HttpStatus.CREATED)
	public DtoAccount crear(@RequestBody DtoAccount dtoAccount) {
		Account account = new Account(dtoAccount.getIdCustomer(), 
				dtoAccount.getAccountNumber(), 
				dtoAccount.getSaldo(), 
				dtoAccount.getProductType()); 
		Account resultAccount =  accountService.save(account);
		return new DtoAccount(resultAccount.getAccountPk().getIdCustomer(), 
				resultAccount.getAccountPk().getAccountNumber(), 
				resultAccount.getSaldo(), resultAccount.getProductType());
	}
	
	
	
	
	@GetMapping(value = "/{accountNumber}/customers/{id_customer}")
	public ResponseEntity detalle(HttpServletRequest request, @PathVariable("id_customer") Long id,
			@PathVariable("accountNumber") String accountNumber) throws Exception{
		Account_pk pk = new Account_pk(id, accountNumber);
		Account account = accountService.findById(pk);

		ResponseEntity resultEntity = null;
		
		if(account !=null) {
			DtoAccount result = new DtoAccount(account.getAccountPk().getIdCustomer(), 
					account.getAccountPk().getAccountNumber(), 
					account.getSaldo(), account.getProductType());
			resultEntity = ResponseEntity.ok(result);
		}else {
			resultEntity =  ResponseEntity.notFound().build();
		}
		
		return resultEntity;
	}
	
	
	
	@DeleteMapping(value = "/{accountNumber}/customers/{id_customer}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity eliminar(@PathVariable("id_customer") Long id,
			@PathVariable("accountNumber") String accountNumber){
		Account_pk pk = new Account_pk(id, accountNumber);
		
		Account account = accountService.findById(pk);
		
		if(account == null) {
			return  ResponseEntity.notFound().build();
		}else {
			accountService.deleteById(pk);
			return  ResponseEntity.ok().build();
		}
		
		
	}
	
	@PutMapping(value = "/{accountNumber}/customers/{id_customer}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public DtoAccount editar(@RequestBody DtoAccount dtoAccount, @PathVariable("id_customer") Long id,
			@PathVariable("accountNumber") String accountNumber) {
		Account account = new Account(id, accountNumber, dtoAccount.getSaldo(), dtoAccount.getProductType()); 
		Account resultAccount =  accountService.save(account);
		return new DtoAccount(resultAccount.getAccountPk().getIdCustomer(), 
				resultAccount.getAccountPk().getAccountNumber(), 
				resultAccount.getSaldo(), resultAccount.getProductType());
	}
	
}
