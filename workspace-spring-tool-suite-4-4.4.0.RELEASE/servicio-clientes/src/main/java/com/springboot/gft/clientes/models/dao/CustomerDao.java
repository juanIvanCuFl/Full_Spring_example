package com.springboot.gft.clientes.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.gft.clientes.models.entity.Customer;

public interface CustomerDao extends CrudRepository<Customer, Long>{

}
