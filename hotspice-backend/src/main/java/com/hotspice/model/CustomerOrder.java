package com.hotspice.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customerorder")
public class CustomerOrder {

	@Id
	@Field(value = "customer_order_id")
	private String customerOrderId;

	@DBRef
	private List<OrderedDish> orderedDishes;

	@Indexed
	@Field(value = "status")
	private String status;

	@Field(value = "placed_at")
	private Date placedAt;

	public String getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	public List<OrderedDish> getOrderedDishes() {
		return orderedDishes;
	}

	public void setOrderedDishes(List<OrderedDish> orderedDishes) {
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

}
