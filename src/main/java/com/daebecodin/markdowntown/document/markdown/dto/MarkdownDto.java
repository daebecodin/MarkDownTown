package com.daebecodin.markdowntown.document.markdown.dto;

import com.daebecodin.markdowntown.document.markdown.Markdown;

import java.time.LocalDateTime;
import java.util.UUID;

public class MarkdownDto {
    private UUID id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static MarkdownDto fromEntity(Markdown markdown) {
        MarkdownDto dto = new MarkdownDto();
        dto.setId(markdown.getId());
        dto.setTitle(markdown.getTitle());
        dto.setContent(markdown.getContent());
        dto.setUpdatedAt(markdown.getUpdatedAt());

        return dto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
