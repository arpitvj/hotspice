package com.hotspice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotspice.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String>{

}
