package com.love.land.domain.dto;

import com.love.land.domain.entity.FileType;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FileContentDto that = (FileContentDto) o;
        return fileType == that.fileType &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fileType, url);
    }
}