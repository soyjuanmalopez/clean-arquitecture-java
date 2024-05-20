package com.d4i.sample.movie.delivery;

import java.util.Collection;

import com.d4i.sample.movie.delivery.responses.NetflixResponse;
import com.d4i.sample.movie.delivery.rest.CategoryRest;
import com.d4i.sample.movie.shared.exceptions.NetflixException;

public interface CategoryController {

	NetflixResponse<Collection<CategoryRest>> getCategories() throws NetflixException;

	NetflixResponse<Boolean> createCategory(CategoryRest category) throws NetflixException;

}
