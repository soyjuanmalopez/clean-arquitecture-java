package com.d4i.clean.core.category.usecase;

import java.util.Collection;

import com.d4i.clean.core.category.Category;
import com.d4i.clean.core.category.ports.CategoryRepositoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAllCategoriesUseCaseImpl implements GetAllCategoriesUseCase {

	private final CategoryRepositoryService categoryRepositoryService;

	@Override
	public Collection<Category> execute() {
		return categoryRepositoryService.getAllCategories();
	}

}
