package com.hotspice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotspice.model.Dish;

public interface DishRepository extends MongoRepository<Dish, String>{

}
