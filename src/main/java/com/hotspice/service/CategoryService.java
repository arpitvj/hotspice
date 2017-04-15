package com.hotspice.service;

import java.util.List;

import com.hotspice.dto.CategoryDto;
import com.hotspice.model.Category;

public interface CategoryService {

	public List<CategoryDto> findAll();
	
	public CategoryDto save(CategoryDto categoryDto);
}