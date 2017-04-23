package com.hotspice.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotspice.dto.CategoryDto;
import com.hotspice.service.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<CategoryDto> categories() {
		return categoryServiceImpl.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CategoryDto save(@RequestBody final CategoryDto categoryDto) {
		return categoryServiceImpl.save(categoryDto);
	}
}