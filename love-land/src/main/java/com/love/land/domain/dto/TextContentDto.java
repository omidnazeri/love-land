package com.love.land.domain.dto;

import java.util.Objects;

public class TextContentDto extends ContentDto {
    private String body;

    public TextContentDto() {
    }

    public TextContentDto(String id, String categoryId, String title, String body) {
        super(id, categoryId, title);
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TextContentDto that = (TextContentDto) o;
        return Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), body);
    }
}