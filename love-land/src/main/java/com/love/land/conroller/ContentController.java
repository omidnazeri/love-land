package com.love.land.conroller;

import com.love.land.domain.dto.ContentDto;
import com.love.land.service.ContentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("content")
public class ContentController {
    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("info/{id}")
    public ResponseEntity<ContentDto> info(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(contentService.getContent(id));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("list/{page}/{size}")
    public ResponseEntity<List<ContentDto>> list(@PathVariable("page") int page,
                                                 @PathVariable("size") int size,
                                                 @RequestParam("category") String category) {
        try {
            return ResponseEntity.ok(contentService.getContents(category, page, size));
        }
        catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
