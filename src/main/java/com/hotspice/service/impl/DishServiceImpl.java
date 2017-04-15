package com.hotspice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotspice.dao.DishDao;
import com.hotspice.dto.DishDto;
import com.hotspice.model.Dish;
import com.hotspice.service.DishService;

@Service
public class DishServiceImpl implements DishService {

	@Autowired
	private DishDao dishDaoImpl;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<DishDto> findAll() {

		List<DishDto> dishDtos = new ArrayList<DishDto>();
		List<Dish> dishes = dishDaoImpl.findAll();

		for (Dish dish : dishes) {

			dishDtos.add(convertToDto(dish));
		}
		return dishDtos;
	}

	@Override
	public DishDto save(DishDto dishDto) {

		Dish dish = convertToModel(dishDto);
		dish = dishDaoImpl.save(dish);

		return convertToDto(dish);
	}

	private DishDto convertToDto(Dish dish) {
		DishDto dishDto = modelMapper.map(dish, DishDto.class);
		return dishDto;
	}

	private Dish convertToModel(DishDto dishDto) {
		Dish dish = modelMapper.map(dishDto, Dish.class);
		return dish;
	}
}