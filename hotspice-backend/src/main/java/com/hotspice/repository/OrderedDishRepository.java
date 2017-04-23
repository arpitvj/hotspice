package com.hotspice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotspice.model.OrderedDish;

public interface OrderedDishRepository extends MongoRepository<OrderedDish, String> {

}
