package com.hotspice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ordereddish")
public class OrderedDish {

	@Id
	@Field(value = "ordered_dish_id")
	private String orderedDishId;

	@DBRef
	private Dish dish;

	@Field(value = "quantity")
	private int quantity;

	@Field(value = "comments")
	private String comments;

	public String getOrderedDishId() {
		return orderedDishId;
	}

	public void setOrderedDishId(String orderedDishId) {
		this.orderedDishId = orderedDishId;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
