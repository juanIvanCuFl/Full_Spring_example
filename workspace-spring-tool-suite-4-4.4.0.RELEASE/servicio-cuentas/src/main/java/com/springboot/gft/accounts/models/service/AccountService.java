package com.springboot.gft.accounts.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.gft.accounts.models.dao.AccountDao;
import com.springboot.gft.accounts.models.entity.Account;
import com.springboot.gft.accounts.models.entity.Account_pk;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Account> findAll() {
		return (List<Account>) accountDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Account findById(Account_pk id) {
		return accountDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Account save(Account account) {
		return accountDao.save(account);
	}

	@Override
	@Transactional
	public void deleteById(Account_pk id) {
		accountDao.deleteById(id);
	}

}
