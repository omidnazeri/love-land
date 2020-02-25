package com.love.land.conroller;

import com.love.land.domain.dto.CategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @RequestMapping("list")
    public ResponseEntity<List<CategoryDto>> list(@RequestParam("parent") String parent) {
        return ResponseEntity.notFound().build();
    }
}
