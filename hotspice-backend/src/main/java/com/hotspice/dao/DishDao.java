package com.hotspice.dao;

import java.util.List;

import com.hotspice.model.Dish;

public interface DishDao {

	public List<Dish> findAll();

	public Dish findOne(String dishId);

	public Iterable<Dish> find(List<String> dishId);

	public Dish save(Dish dish);
}
