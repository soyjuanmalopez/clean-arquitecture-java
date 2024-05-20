package com.d4i.sample.movie.persistence.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.category.ports.CategoryRepositoryService;
import com.d4i.sample.movie.persistence.converters.CategoryRepositoryConverter;
import com.d4i.sample.movie.persistence.repositories.CategoryRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryServiceImpl implements CategoryRepositoryService {

	private final CategoryRepository categoryRepository;
	private final CategoryRepositoryConverter categoryRepositoryConverter;

    @Override
	public Collection<Category> getAllCategories() {
		return categoryRepository.findAll().stream().map(categoryRepositoryConverter::mapToEntity)
				.collect(Collectors.toList());
		
	}

	@Override
	public void saveCategory(final Category category) {
		categoryRepository.save(categoryRepositoryConverter.mapToTable(category));
	}

	public Boolean doesCategoryNameExists(final String name) {
		return !categoryRepository.findByName(name).isEmpty();
	}

}
