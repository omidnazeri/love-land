package com.love.land.domain.entity;

import com.love.land.domain.dto.ContentDto;
import com.love.land.domain.dto.FileContentDto;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "file")
public class FileContent extends Content {
    @Enumerated(value = EnumType.STRING)
    @Column(name = "c_file_type")
    private FileType fileType;

    @Column(name = "c_url")
    private String url;

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
    public ContentDto toDto() {
        return new FileContentDto(getId(),
                getCategory() != null ? getCategory().getId() : null,
                getTitle(), fileType, url);
    }
}
