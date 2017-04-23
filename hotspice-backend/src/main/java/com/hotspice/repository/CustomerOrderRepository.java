package com.hotspice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hotspice.model.CustomerOrder;

public interface CustomerOrderRepository extends MongoRepository<CustomerOrder, String> {

}
