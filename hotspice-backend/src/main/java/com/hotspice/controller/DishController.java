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

import com.hotspice.dto.DishDto;
import com.hotspice.service.DishService;

@RestController
@RequestMapping(value = "/dishes")
public class DishController {

	@Autowired
	private DishService dishServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<DishDto> dishes() {
		return dishServiceImpl.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public DishDto save(@RequestBody final DishDto dishDto) {
		return dishServiceImpl.save(dishDto);
	}
}