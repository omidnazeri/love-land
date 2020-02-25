package com.love.land.domain.dto;

import com.love.land.domain.entity.FileType;

public class FileContentDto extends ContentDto {
    private FileType fileType;
    private String url;

    public FileContentDto() {
    }

    public FileContentDto(String id, String categoryId, String title, FileType fileType, String url) {
        super(id, categoryId, title);
        this.fileType = fileType;
        this.url = url;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
