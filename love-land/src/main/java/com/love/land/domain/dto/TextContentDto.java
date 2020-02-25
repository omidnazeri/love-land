package com.love.land.domain.dto;

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
}
