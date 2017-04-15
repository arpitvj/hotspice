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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotspice.dto.CategoryDto;
import com.hotspice.service.OperationsService;

@RestController
public class OperationsController {

	@Autowired
	private OperationsService operationsServiceImpl;
	
	@RequestMapping(value="/categories/dishes/{categoryId}", method = RequestMethod.PUT)
	@ResponseBody
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CategoryDto addDishesToCategory(@PathVariable("categoryId") final String categoryId, @RequestBody final List<String> dishIds) {
		
		return operationsServiceImpl.addDishesToCategory(categoryId, dishIds);
	}
}
