package com.hotspice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotspice.dao.CategoryDao;
import com.hotspice.dto.CategoryDto;
import com.hotspice.model.Category;
import com.hotspice.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDaoImpl;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<CategoryDto> findAll() {
		List<Category> categories = categoryDaoImpl.findAll();
		List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();
		categories.forEach(category -> categoryDtos.add(convertToDto(category)));
		return categoryDtos;
	}

	@Override
	public CategoryDto save(CategoryDto categoryDto) {
		
		Category category = convertToModel(categoryDto);
		category = categoryDaoImpl.save(category);
		
		return convertToDto(category);
	}

	private CategoryDto convertToDto(Category category) {
		CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
	    return categoryDto;
	}
	
	private Category convertToModel(CategoryDto categoryDto) {
		Category category = modelMapper.map(categoryDto, Category.class);
	    return category;
	}
}