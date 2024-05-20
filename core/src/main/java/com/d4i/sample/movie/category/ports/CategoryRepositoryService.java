package com.d4i.sample.movie.category.ports;

import java.util.Collection;

import com.d4i.sample.movie.category.Category;

public interface CategoryRepositoryService {

	Collection<Category> getAllCategories();
	
	void saveCategory(Category category) ;

	Boolean doesCategoryNameExists(String name);
}
