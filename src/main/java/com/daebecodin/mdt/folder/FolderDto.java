package com.daebecodin.mdt.folder;

import com.daebecodin.mdt.markdown.Markdown;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FolderDto {
    private UUID id;
    private String name;
    private List<Markdown> markdowns;

    public static FolderDto fromEntity(Folder folder) {
        FolderDto dto = new FolderDto();
        dto.setId(folder.getId());
        dto.setName(folder.getName());
        dto.setMarkdowns(folder.getMarkdowns());

        return dto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Markdown> getMarkdowns() {
        return markdowns;
    }

    public void setMarkdowns(List<Markdown> markdowns) {
        this.markdowns = markdowns;
    }
}
