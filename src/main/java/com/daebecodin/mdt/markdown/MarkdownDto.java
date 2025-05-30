package com.daebecodin.mdt.markdown;

import com.daebecodin.mdt.folder.Folder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class MarkdownDto {
    private UUID id;
    private String title;
    private String content;
//    private Folder folder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static MarkdownDto fromEntity(Markdown markdown) {
        MarkdownDto dto = new MarkdownDto();
        dto.setId(markdown.getId());
        dto.setTitle(markdown.getTitle());
        dto.setContent(markdown.getContent());
//        dto.setFolder(markdown.getFolder());
        dto.setCreatedAt(markdown.getCreatedAt());
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

//    public Folder getFolder() {
//        return folder;
//    }
//
//    public void setFolder(Folder folder) {
//        this.folder = folder;
//    }
}
