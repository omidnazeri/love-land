package com.love.land.service;

import com.love.land.domain.dto.CategoryDto;
import com.love.land.domain.dto.ContentDto;
import com.love.land.domain.entity.Category;
import com.love.land.domain.entity.Content;
import com.love.land.domain.repository.CategoryRepository;
import com.love.land.domain.repository.ContentRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentService {
    private final CategoryRepository categoryRepository;
    private final ContentRepository contentRepository;

    public ContentService(CategoryRepository categoryRepository,
                          ContentRepository contentRepository) {
        this.categoryRepository = categoryRepository;
        this.contentRepository = contentRepository;
    }

    public CategoryDto addCategory(String parentId, String title) {
        Category parent = null;

        if (!Strings.isEmpty(parentId)) {
            parent = categoryRepository.findById(parentId).orElseThrow(InvalidParameterException::new);
        }

        Category category = new Category();
        category.setParent(parent);
        category.setTitle(title);

        return categoryRepository.save(category).toDto();
    }

    @Transactional
    public List<CategoryDto> getCategories(String parentId) {
        Category parent = null;

        if (!Strings.isEmpty(parentId)) {
            parent = categoryRepository.findById(parentId).orElseThrow(InvalidParameterException::new);
        }

        return categoryRepository.findAllByParent(parent).
                map(Category::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<ContentDto> getContents(String category, int page, int size) {
        Category parent = null;

        if (!Strings.isEmpty(category)) {
            parent = categoryRepository.findById(category).orElseThrow(InvalidParameterException::new);
        }

        Pageable pageable = PageRequest.of(page, size);

        return contentRepository.findAllByCategory(parent, pageable).
                map(Content::toDto).collect(Collectors.toList());
    }

    @Transactional
    public ContentDto getContent(String contentId) {
        return contentRepository.findById(contentId).orElseThrow(InvalidParameterException::new).toDto();
    }
}
