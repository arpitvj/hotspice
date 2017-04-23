package com.hotspice.dto;

public class OrderedDishDto {

	private String orderedDishId;
	private String selectedDishId;
	private DishDto dish;
	private int quantity;
	private String comments;

	public String getOrderedDishId() {
		return orderedDishId;
	}

	public void setOrderedDishId(String orderedDishId) {
		this.orderedDishId = orderedDishId;
	}

	public String getSelectedDishId() {
		return selectedDishId;
	}

	public void setSelectedDishId(String selectedDishId) {
		this.selectedDishId = selectedDishId;
	}

	public DishDto getDish() {
		return dish;
	}

	public void setDish(DishDto dish) {
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
