package com.hotspice.dao;

import java.util.List;

import com.hotspice.model.Category;

public interface CategoryDao {

	public List<Category> findAll();
	
	public Category save(Category category);
	
	public Category find(String categoryId);
}
