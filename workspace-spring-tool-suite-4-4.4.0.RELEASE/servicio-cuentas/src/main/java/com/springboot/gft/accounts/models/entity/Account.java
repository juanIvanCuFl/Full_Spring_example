package com.springboot.gft.accounts.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account implements Serializable{

	private static final long serialVersionUID = 4272078269685494521L;
	@EmbeddedId
	private Account_pk accountPk;
	
	
	private Double saldo;
	@Column(name = "product_type")
	private String productType;
	
	
	
	public Account() {
		super();
	}

	public Account(Long id_customer,String accountNumber, Double saldo, String productType) {
		super();
		this.accountPk = new Account_pk(id_customer, accountNumber);
		this.saldo = saldo;
		this.productType = productType;
	}
	
	public Account_pk getAccountPk() {
		return accountPk;
	}
	public void setAccountPk(Account_pk accountPk) {
		this.accountPk = accountPk;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
