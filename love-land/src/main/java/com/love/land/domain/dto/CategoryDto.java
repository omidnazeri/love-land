package com.love.land.domain.dto;

import java.util.Objects;

public class CategoryDto {
    private String id;
    private String parentId;
    private String title;

    public CategoryDto() {;
    }

    public CategoryDto(String id, String parentId, String title) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
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
        CategoryDto dto = (CategoryDto) o;
        return Objects.equals(id, dto.id) &&
                Objects.equals(parentId, dto.parentId) &&
                Objects.equals(title, dto.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parentId, title);
    }
}
