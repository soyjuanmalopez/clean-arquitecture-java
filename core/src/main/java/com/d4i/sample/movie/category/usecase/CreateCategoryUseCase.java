package com.d4i.sample.movie.category.usecase;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.category.exception.CategoryAlreadyExistException;

public interface CreateCategoryUseCase {

	void execute(Category category) throws CategoryAlreadyExistException ;

}
