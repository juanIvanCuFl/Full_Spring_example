package com.springboot.gft.accountse.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.gft.accountse.clients.AccountClientRest;
import com.springboot.gft.accountse.facade.dto.DtoAccount;

import feign.FeignException;

@Service("serviceFeign")
public class AccountService implements IAccountService {

	@Autowired
	private AccountClientRest clienteFeing;

	@Override
	public List<DtoAccount> listar() {
		return clienteFeing.listar();
	}

	@Override
	public DtoAccount crear(DtoAccount dtoAccount) {
		return clienteFeing.crear(dtoAccount);
	}

	@Override
	public DtoAccount detalle(Long id, String accountNumber) {
		try {
			return clienteFeing.detalle(id, accountNumber);
		} catch (FeignException e) {
			if (e.status() == 404) {
				return null;
			} else {
				throw e;
			}
		}
	}

	@Override
	public int eliminar(Long id, String accountNumber) {
		try {
			clienteFeing.eliminar(id, accountNumber);
			return 204;
		} catch (FeignException e) {
			if (e.status() == 404) {
				return 404;
			} else {
				throw e;
			}
		}
	}

	@Override
	public DtoAccount editar(DtoAccount dtoAccount, Long id, String accountNumber) {
		return clienteFeing.editar(dtoAccount, id, accountNumber);
	}

}
