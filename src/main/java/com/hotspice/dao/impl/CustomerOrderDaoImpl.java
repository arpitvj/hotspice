package com.hotspice.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.hotspice.constants.ApplicationConstants;
import com.hotspice.dao.CustomerOrderDao;
import com.hotspice.model.CustomerOrder;
import com.hotspice.repository.CustomerOrderRepository;

@Component
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	@Autowired
	private CustomerOrderRepository customerOrderRepository;
	
	@Autowired
	private MongoOperations mongoOperations;

	@Override
	public CustomerOrder save(CustomerOrder customerOrder) {

		return customerOrderRepository.save(customerOrder);
	}

	@Override
	public CustomerOrder find(String customerOrderId) {

		return customerOrderRepository.findOne(customerOrderId);
	}

	@Override
	public List<CustomerOrder> findAll() {
		
		return customerOrderRepository.findAll();
	}

	@Override
	public List<CustomerOrder> findAllWithStatusCriteria(String filterValue, String sortField, String sort) {
		
		Query query = new Query();
		if(!StringUtils.isEmpty(filterValue)){
			query.addCriteria(Criteria.where(ApplicationConstants.ORDER_STATUS_FIELD_NAME).is(filterValue));	
		}
		
		if(ApplicationConstants.DESCENDING_ORDER.equals(sort)){
			query.with(new Sort(Sort.Direction.DESC, sortField));	
		} else{
			query.with(new Sort(Sort.Direction.ASC, sortField));
		}
		
		
		return mongoOperations.find(query, CustomerOrder.class); 
	}
}
