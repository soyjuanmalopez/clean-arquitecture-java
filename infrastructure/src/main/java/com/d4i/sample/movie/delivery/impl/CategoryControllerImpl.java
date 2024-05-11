package com.d4i.sample.movie.delivery.impl;

import com.d4i.sample.movie.category.exception.CategoryAlreadyExistException;
import com.d4i.sample.movie.category.usecase.CreateCategoryUseCase;
import com.d4i.sample.movie.category.usecase.GetAllCategoriesUseCase;
import com.d4i.sample.movie.delivery.CategoryController;
import com.d4i.sample.movie.delivery.converters.CategoryRestConverter;
import com.d4i.sample.movie.delivery.responses.NetflixResponse;
import com.d4i.sample.movie.delivery.rest.CategoryRest;
import com.d4i.sample.movie.shared.constants.CommonConstants;
import com.d4i.sample.movie.shared.constants.RestConstants;
import com.d4i.sample.movie.shared.exceptions.NetflixException;
import jakarta.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstants.APPLICATION_NAME + RestConstants.API_VERSION_1 + RestConstants.RESOURCE_CATEGORY)
public class CategoryControllerImpl implements CategoryController {

	private final GetAllCategoriesUseCase getAllCategoriesUseCase;

	private final CreateCategoryUseCase createCategoryUseCase;

	private final CategoryRestConverter categoryRestConverter;

    public CategoryControllerImpl(GetAllCategoriesUseCase getAllCategoriesUseCase, CreateCategoryUseCase createCategoryUseCase,
                                  CategoryRestConverter categoryRestConverter) {
        this.getAllCategoriesUseCase = getAllCategoriesUseCase;
        this.createCategoryUseCase = createCategoryUseCase;
        this.categoryRestConverter = categoryRestConverter;
    }

    @Override
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<Collection<CategoryRest>> getCategories() throws NetflixException {
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK,
				getAllCategoriesUseCase.execute().stream().map(categoryRestConverter::mapToRest)
						.collect(Collectors.toList()));
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public NetflixResponse<Boolean> createCategory(@Valid @RequestBody final CategoryRest category) throws NetflixException {
		
		try {
			createCategoryUseCase.execute(categoryRestConverter.mapToEntity(category));
		} catch (CategoryAlreadyExistException e) {
			e.printStackTrace();
			
		}
		
		return new NetflixResponse<>(CommonConstants.SUCCESS, String.valueOf(HttpStatus.OK), CommonConstants.OK);
	}

}
