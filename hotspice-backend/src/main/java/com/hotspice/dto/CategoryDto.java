package com.hotspice.dto;

import java.util.List;

public class CategoryDto {

	private String categoryId;
	private String categoryName;

	private List<DishDto> dishes;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<DishDto> getDishes() {
		return dishes;
	}

	public void setDishes(List<DishDto> dishes) {
		this.dishes = dishes;
	}

}
