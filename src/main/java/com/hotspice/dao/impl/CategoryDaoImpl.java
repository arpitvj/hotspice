package com.hotspice.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotspice.dao.CategoryDao;
import com.hotspice.model.Category;
import com.hotspice.repository.CategoryRepository;

@Component
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public Category find(String categoryId) {
		
		return categoryRepository.findOne(categoryId);
	}
}
