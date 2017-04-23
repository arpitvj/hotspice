package com.hotspice.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.hotspice.constants.ApplicationConstants;
import com.hotspice.dao.CustomerOrderDao;
import com.hotspice.dao.DishDao;
import com.hotspice.dao.OrderedDishDao;
import com.hotspice.dto.CustomerOrderDto;
import com.hotspice.dto.OrderedDishDto;
import com.hotspice.model.CustomerOrder;
import com.hotspice.model.Dish;
import com.hotspice.model.OrderedDish;
import com.hotspice.service.CustomerOrderService;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderDao customerOrderDaoImpl;

	@Autowired
	private OrderedDishDao orderedDishDaoImpl;

	@Autowired
	private DishDao dishDaoImpl;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerOrderDto placeOrder(CustomerOrderDto customerOrderDto) {

		List<OrderedDish> orderedDishes = new ArrayList<OrderedDish>();
		for (OrderedDishDto orderedDishDto : customerOrderDto.getOrderedDishes()) {
			Dish dish = dishDaoImpl.findOne(orderedDishDto.getSelectedDishId());
			dish.setOrderCount(dish.getOrderCount() + 1);
			dishDaoImpl.save(dish);
			
			OrderedDish orderedDish = convertToModel(orderedDishDto);
			orderedDish.setDish(dish);

			orderedDishes.add(orderedDishDaoImpl.save(orderedDish));
		}

		CustomerOrder customerOrder = convertToModel(customerOrderDto);

		customerOrder.setPlacedAt(new Date());
		customerOrder.setStatus(ApplicationConstants.ORDER_STATUS_PLACED);
		customerOrder.setOrderedDishes(orderedDishes);

		customerOrderDto = convertToDto(customerOrderDaoImpl.save(customerOrder));
		customerOrderDto.setStatusCode(ApplicationConstants.ORDER_STATUS_PLACED_CODE);

		return customerOrderDto;
	}

	@Override
	public CustomerOrderDto updateStatus(final String customerOrderId, final String statusCode) {

		CustomerOrder customerOrder = customerOrderDaoImpl.find(customerOrderId);

		if (ApplicationConstants.ORDER_STATUS_PLACED_CODE.equals(statusCode)) {
			customerOrder.setStatus(ApplicationConstants.ORDER_STATUS_PLACED);
		} else if (ApplicationConstants.ORDER_STATUS_PREPARING_CODE.equals(statusCode)) {
			customerOrder.setStatus(ApplicationConstants.ORDER_STATUS_PREPARING);
		} else if (ApplicationConstants.ORDER_STATUS_DISPATCHED_CODE.equals(statusCode)) {
			customerOrder.setStatus(ApplicationConstants.ORDER_STATUS_DISPATCHED);
		} else if (ApplicationConstants.ORDER_STATUS_DELIVERED_CODE.equals(statusCode)) {
			customerOrder.setStatus(ApplicationConstants.ORDER_STATUS_DELIVERED);
		} else {
			customerOrder.setStatus(ApplicationConstants.ORDER_STATUS_FULFILLED);
		}

		return convertToDto(customerOrderDaoImpl.save(customerOrder));
	}

	@Override
	public List<CustomerOrderDto> allCustomerOrders() {

		List<CustomerOrder> customerOrders = customerOrderDaoImpl.findAll();

		List<CustomerOrderDto> customerOrderDtos = new ArrayList<CustomerOrderDto>();
		for (CustomerOrder customerOrder : customerOrders) {
			CustomerOrderDto customerOrderDto = convertToDto(customerOrder);
			if (ApplicationConstants.ORDER_STATUS_PLACED.equals(customerOrderDto.getStatus())) {
				customerOrderDto.setStatusCode(ApplicationConstants.ORDER_STATUS_PLACED_CODE);
			} else if (ApplicationConstants.ORDER_STATUS_PREPARING.equals(customerOrderDto.getStatus())) {
				customerOrderDto.setStatusCode(ApplicationConstants.ORDER_STATUS_PREPARING_CODE);
			} else if (ApplicationConstants.ORDER_STATUS_DISPATCHED.equals(customerOrderDto.getStatus())) {
				customerOrderDto.setStatusCode(ApplicationConstants.ORDER_STATUS_DISPATCHED_CODE);
			} else if (ApplicationConstants.ORDER_STATUS_DELIVERED.equals(customerOrderDto.getStatus())) {
				customerOrderDto.setStatusCode(ApplicationConstants.ORDER_STATUS_DELIVERED_CODE);
				customerOrder.setStatus(ApplicationConstants.ORDER_STATUS_DELIVERED);
			} else {
				customerOrderDto.setStatusCode(ApplicationConstants.ORDER_STATUS_FULFILLED_CODE);
			}

			customerOrderDtos.add(customerOrderDto);
		}

		return customerOrderDtos;
	}

	@Override
	public CustomerOrderDto orderDetails(final String customerOrderId) {

		CustomerOrder customerOrder = customerOrderDaoImpl.find(customerOrderId);
		return convertToDto(customerOrder);
	}

	@Override
	public List<CustomerOrderDto> allCustomerOrders(final String status, final String sort, final String sortDirection) {

		String statusValue = "";
		String sortField = ApplicationConstants.ORDER_PLACED_AT_FIELD;
		String direction = ApplicationConstants.DESCENDING_ORDER;
		if (!StringUtils.isEmpty(sortDirection)) {
			direction = sortDirection;
			if (!ApplicationConstants.ASCENDING_ORDER.equals(direction)
					&& !ApplicationConstants.DESCENDING_ORDER.equals(direction)) {
				direction = ApplicationConstants.DESCENDING_ORDER;
			}
		}

		if(!StringUtils.isEmpty(sort)){
			sortField = sort;
		}
		
		if (!StringUtils.isEmpty(status)) {
			if (ApplicationConstants.ORDER_STATUS_PLACED_CODE.equals(status)) {
				statusValue = ApplicationConstants.ORDER_STATUS_PLACED;
			} else if (ApplicationConstants.ORDER_STATUS_PREPARING_CODE.equals(status)) {
				statusValue = ApplicationConstants.ORDER_STATUS_PREPARING;
			} else if (ApplicationConstants.ORDER_STATUS_DISPATCHED_CODE.equals(status)) {
				statusValue = ApplicationConstants.ORDER_STATUS_DISPATCHED;
			} else if (ApplicationConstants.ORDER_STATUS_DELIVERED_CODE.equals(status)) {
				statusValue = ApplicationConstants.ORDER_STATUS_DELIVERED;
			} else {
				statusValue = ApplicationConstants.ORDER_STATUS_FULFILLED;
			}
		}

		List<CustomerOrder> customerOrders = customerOrderDaoImpl.findAllWithStatusCriteria(statusValue, sortField,
				direction);
		List<CustomerOrderDto> customerOrderDtos = new ArrayList<CustomerOrderDto>();
		for (CustomerOrder customerOrder : customerOrders) {
			CustomerOrderDto customerOrderDto = convertToDto(customerOrder);
			if (ApplicationConstants.ORDER_STATUS_PLACED.equals(customerOrderDto.getStatus())) {
				customerOrderDto.setStatusCode(ApplicationConstants.ORDER_STATUS_PLACED_CODE);
			} else if (ApplicationConstants.ORDER_STATUS_PREPARING.equals(customerOrderDto.getStatus())) {
				customerOrderDto.setStatusCode(ApplicationConstants.ORDER_STATUS_PREPARING_CODE);
			} else if (ApplicationConstants.ORDER_STATUS_DISPATCHED.equals(customerOrderDto.getStatus())) {
				customerOrderDto.setStatusCode(ApplicationConstants.ORDER_STATUS_DISPATCHED_CODE);
			} else if (ApplicationConstants.ORDER_STATUS_DELIVERED.equals(customerOrderDto.getStatus())) {
				customerOrderDto.setStatusCode(ApplicationConstants.ORDER_STATUS_DELIVERED_CODE);
			} else {
				customerOrderDto.setStatusCode(ApplicationConstants.ORDER_STATUS_FULFILLED_CODE);
			}

			customerOrderDtos.add(customerOrderDto);
		}

		return customerOrderDtos;
	}

	private CustomerOrderDto convertToDto(CustomerOrder customerOrder) {
		CustomerOrderDto customerOrderDto = modelMapper.map(customerOrder, CustomerOrderDto.class);
		return customerOrderDto;
	}

	private CustomerOrder convertToModel(CustomerOrderDto customerOrderDto) {
		CustomerOrder customerOrder = modelMapper.map(customerOrderDto, CustomerOrder.class);
		return customerOrder;
	}

	private OrderedDishDto convertToDto(OrderedDish orderedDish) {
		OrderedDishDto orderedDishDto = modelMapper.map(orderedDish, OrderedDishDto.class);
		return orderedDishDto;
	}

	private OrderedDish convertToModel(OrderedDishDto orderedDishDto) {
		OrderedDish orderedDish = modelMapper.map(orderedDishDto, OrderedDish.class);
		return orderedDish;
	}

}
