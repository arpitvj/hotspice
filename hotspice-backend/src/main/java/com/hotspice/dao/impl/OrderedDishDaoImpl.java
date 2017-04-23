package com.hotspice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotspice.dao.OrderedDishDao;
import com.hotspice.model.OrderedDish;
import com.hotspice.repository.OrderedDishRepository;

@Component
public class OrderedDishDaoImpl implements OrderedDishDao {

	@Autowired
	private OrderedDishRepository orderedDishRepository;

	@Override
	public OrderedDish save(OrderedDish orderedDish) {

		return orderedDishRepository.save(orderedDish);
	}

}
