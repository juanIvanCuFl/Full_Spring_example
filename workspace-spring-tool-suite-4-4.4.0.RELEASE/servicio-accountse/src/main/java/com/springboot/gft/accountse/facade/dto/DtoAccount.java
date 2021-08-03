package com.springboot.gft.accountse.facade.dto;

import java.io.Serializable;

public class DtoAccount implements Serializable{

	private static final long serialVersionUID = 1615616336520145431L;
	private Long idCustomer;
	private String accountNumber;
	private Double saldo;
	private String productType;
	
	
	public DtoAccount(Long idCustomer, String accountNumber, Double saldo, String productType) {
		super();
		this.idCustomer = idCustomer;
		this.accountNumber = accountNumber;
		this.saldo = saldo;
		this.productType = productType;
	}
	public DtoAccount() {
		super();
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
}
