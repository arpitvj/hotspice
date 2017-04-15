package com.hotspice.dto;

import java.util.Date;
import java.util.List;

public class CustomerOrderDto {

	private String customerOrderId;
	private List<OrderedDishDto> orderedDishes;
	private String status;
	private String statusCode;
	private Date placedAt;

	public String getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public List<OrderedDishDto> getOrderedDishes() {
		return orderedDishes;
	}

	public void setOrderedDishes(List<OrderedDishDto> orderedDishes) {
		this.orderedDishes = orderedDishes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPlacedAt() {
		return placedAt;
	}

	public void setPlacedAt(Date placedAt) {
		this.placedAt = placedAt;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
