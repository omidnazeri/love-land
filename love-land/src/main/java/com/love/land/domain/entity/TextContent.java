package com.love.land.domain.entity;

import com.love.land.domain.dto.ContentDto;
import com.love.land.domain.dto.TextContentDto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "text")
public class TextContent extends Content {
    @Column(name = "c_body", length = 999)
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public ContentDto toDto() {
        return new TextContentDto(getId(),
                getCategory() != null ? getCategory().getId() : null,
                getTitle(), body);
    }

}
