package com.springboot.gft.accounts.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.gft.accounts.models.entity.Account;
import com.springboot.gft.accounts.models.entity.Account_pk;

public interface AccountDao extends CrudRepository<Account, Account_pk>{

}
