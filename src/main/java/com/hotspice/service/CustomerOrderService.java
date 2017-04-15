package com.hotspice.service;

import java.util.List;

import com.hotspice.dto.CustomerOrderDto;

public interface CustomerOrderService {

	public CustomerOrderDto placeOrder(CustomerOrderDto customerOrderDto);
	
	public CustomerOrderDto updateStatus(String customerOrderId, String statusCode);
	
	public List<CustomerOrderDto> allCustomerOrders(final String status, final String sort, final String direction);
	
	public List<CustomerOrderDto> allCustomerOrders();
	
	public CustomerOrderDto orderDetails(String customerOrderId);
}
