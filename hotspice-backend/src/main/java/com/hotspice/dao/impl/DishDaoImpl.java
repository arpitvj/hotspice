package com.hotspice.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotspice.dao.DishDao;
import com.hotspice.model.Dish;
import com.hotspice.repository.DishRepository;

@Component
public class DishDaoImpl implements DishDao {

	@Autowired
	private DishRepository dishRepository;

	@Override
	public List<Dish> findAll() {

		return dishRepository.findAll();
	}

	@Override
	public Iterable<Dish> find(List<String> dishId) {

		return dishRepository.findAll(dishId);
	}

	@Override
	public Dish save(Dish dish) {

		return dishRepository.save(dish);
	}

	@Override
	public Dish findOne(String dishId) {

		return dishRepository.findOne(dishId);
	}

}
