package com.springboot.gft.customerse.facade.dto;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable{
	

	private static final long serialVersionUID = -5351078455077334869L;
	private Long id;
	private String name;
	private String app;
	private Date birthdate;
	private String sex;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}

