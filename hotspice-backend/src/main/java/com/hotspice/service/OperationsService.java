package com.hotspice.service;

import java.util.List;

import com.hotspice.dto.CategoryDto;

public interface OperationsService {

	public CategoryDto addDishesToCategory(final String categoryId, final List<String> dishIds);
}
