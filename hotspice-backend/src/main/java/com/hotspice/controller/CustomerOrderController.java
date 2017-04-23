package com.hotspice.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotspice.dto.CustomerOrderDto;
import com.hotspice.service.CustomerOrderService;

@RestController
public class CustomerOrderController {

	@Autowired
	private CustomerOrderService customerOrderServiceImpl;

	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	@ResponseBody
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CustomerOrderDto placeOrder(@RequestBody final CustomerOrderDto customerOrder) {

		return customerOrderServiceImpl.placeOrder(customerOrder);
	}

	@RequestMapping(value = "/orders/{customerOrderId}/status/{statusCode}", method = RequestMethod.PUT)
	@ResponseBody
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CustomerOrderDto updateStatus(@PathVariable(value = "customerOrderId") final String customerOrderId,
			@PathVariable(value = "statusCode") final String statusCode) {

		return customerOrderServiceImpl.updateStatus(customerOrderId, statusCode);
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	@ResponseBody
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<CustomerOrderDto> orders(@RequestParam(value = "status", required = false) final String status,
			@RequestParam(value = "sort", required = false) final String sortField,
			@RequestParam(value = "sortDirection", required = false) final String direction) {

		return customerOrderServiceImpl.allCustomerOrders(status, sortField, direction);
	}

	@RequestMapping(value = "/orders/{customerOrderId}", method = RequestMethod.GET)
	@ResponseBody
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CustomerOrderDto orderDetails(@PathVariable(value = "customerOrderId") final String customerOrderId) {

		return customerOrderServiceImpl.orderDetails(customerOrderId);
	}
}
