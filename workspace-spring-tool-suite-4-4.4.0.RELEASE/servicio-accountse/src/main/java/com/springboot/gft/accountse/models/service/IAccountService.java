package com.springboot.gft.accountse.models.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.gft.accountse.facade.dto.DtoAccount;

public interface IAccountService {

	public List<DtoAccount> listar();
	public DtoAccount crear( DtoAccount dtoAccount) ;
	public DtoAccount detalle( Long id, String accountNumber) ;
	public int eliminar (Long id, String accountNumber);
	public DtoAccount editar(DtoAccount dtoAccount, Long id,
			String accountNumber) ;
}
