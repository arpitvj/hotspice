package com.hotspice.dao;

import java.util.List;

import com.hotspice.model.CustomerOrder;

public interface CustomerOrderDao {

	public CustomerOrder save(CustomerOrder customerOrder);
	
	public CustomerOrder find(String customerOrderId);
	
	public List<CustomerOrder> findAll();
	
	public List<CustomerOrder> findAllWithStatusCriteria(String filterValue, String sortField, String sort);
}
