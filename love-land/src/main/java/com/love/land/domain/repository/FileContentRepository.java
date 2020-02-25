package com.love.land.domain.repository;

import com.love.land.domain.entity.TextContent;
import org.springframework.data.repository.CrudRepository;

public interface FileContentRepository extends CrudRepository<TextContent, String> {

}
