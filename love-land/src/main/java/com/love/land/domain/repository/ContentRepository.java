package com.love.land.domain.repository;

import com.love.land.domain.entity.Category;
import com.love.land.domain.entity.Content;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

public interface ContentRepository extends CrudRepository<Content, String> {
    Stream<Content> findAllByCategory(Category category, Pageable pageable);
}
