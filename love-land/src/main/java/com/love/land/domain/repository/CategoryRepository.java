package com.love.land.domain.repository;

import com.love.land.domain.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface CategoryRepository extends CrudRepository<Category, String> {
    Stream<Category> findAllByParent(Category category);
}
