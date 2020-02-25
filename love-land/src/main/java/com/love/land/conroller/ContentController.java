package com.love.land.conroller;

import com.love.land.domain.dto.ContentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("content")
public class ContentController {
    @RequestMapping("info/{id}")
    public ResponseEntity<ContentDto> info(@PathVariable("id") String id) {
        return ResponseEntity.notFound().build();
    }

    @RequestMapping("list/{page}/{size}")
    public ResponseEntity<List<ContentDto>> list(@PathVariable("page") int page,
                                                 @PathVariable("size") int size) {
        return ResponseEntity.notFound().build();
    }
}
