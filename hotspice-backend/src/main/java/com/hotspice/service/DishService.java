package com.hotspice.service;

import java.util.List;

import com.hotspice.dto.DishDto;

public interface DishService {

	public List<DishDto> findAll();
	
	public DishDto save(DishDto dishDto);
}
