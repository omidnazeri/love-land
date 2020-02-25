package com.love.land.domain.dto;

import java.util.Objects;

public class ContentDto {
    private String id;
    private String categoryId;
    private String title;

    public ContentDto() {
    }

    public ContentDto(String id, String categoryId, String title) {
        this.id = id;
        this.categoryId = categoryId;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentDto that = (ContentDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(categoryId, that.categoryId) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId, title);
    }
}
