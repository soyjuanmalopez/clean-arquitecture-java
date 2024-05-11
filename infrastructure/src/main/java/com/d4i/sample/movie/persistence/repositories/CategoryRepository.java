package com.d4i.sample.movie.persistence.repositories;

import com.d4i.sample.movie.category.Category;
import com.d4i.sample.movie.persistence.entities.CategoryEntity;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	Collection<Category> findByName(String name);
}
