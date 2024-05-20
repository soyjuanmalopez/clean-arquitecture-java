package com.d4i.sample.movie.delivery.converters;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.delivery.rest.CategoryRest;
import com.d4i.sample.movie.shared.RestConverter;

public class CategoryRestConverter implements RestConverter<CategoryRest, Category> {

	@Override
	public Category mapToEntity(final CategoryRest rest) {

		return new Category(null, rest.name(), rest.available());
	}

	@Override
	public CategoryRest mapToRest(final Category entity) {
		return new CategoryRest(entity.getName(), entity.getAvailable());
	}

}
