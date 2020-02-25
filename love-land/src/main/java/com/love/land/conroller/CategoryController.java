package com.love.land.conroller;

import com.love.land.domain.dto.CategoryDto;
import com.love.land.service.ContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    private final ContentService contentService;

    public CategoryController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("list")
    public ResponseEntity<List<CategoryDto>> list(@RequestParam("parent") String parent) {
        try {
            return ResponseEntity.ok(contentService.getCategories(parent));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
