package com.hotspice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotspice.dao.CategoryDao;
import com.hotspice.dao.DishDao;
import com.hotspice.dto.CategoryDto;
import com.hotspice.model.Category;
import com.hotspice.model.Dish;
import com.hotspice.service.OperationsService;

@Service
public class OperationsServiceImpl implements OperationsService {

	@Autowired
	private DishDao dishDaoImpl;
	
	@Autowired
	private CategoryDao categoryDaoImpl;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto addDishesToCategory(final String categoryId, final List<String> dishIds) {
		
		Category category = categoryDaoImpl.find(categoryId);
		Iterable<Dish> iterableDishes = dishDaoImpl.find(dishIds);
		List<Dish> dishes = StreamSupport.stream(iterableDishes.spliterator(), false).collect(Collectors.toList());
		category.setDishes(dishes);
		
		return convertToDto(categoryDaoImpl.save(category)); 
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
