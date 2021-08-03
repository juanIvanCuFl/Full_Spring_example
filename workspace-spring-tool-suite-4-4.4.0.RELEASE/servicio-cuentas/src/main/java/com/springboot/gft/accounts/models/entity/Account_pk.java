package com.springboot.gft.accounts.models.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class Account_pk implements Serializable{

	private static final long serialVersionUID = -9148380087227076928L;
	
	@Column(name = "id_customer")
	private Long idCustomer;
	@Column(name = "account_number")
	private String accountNumber;
	
	public Account_pk() {
		super();
	}
	public Account_pk(Long idCustomer, String accountNumber) {
		super();
		this.idCustomer = idCustomer;
		this.accountNumber = accountNumber;
	}
	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
