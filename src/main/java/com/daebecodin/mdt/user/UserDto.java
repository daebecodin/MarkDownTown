package com.daebecodin.mdt.user;


import com.daebecodin.mdt.folder.Folder;
import com.daebecodin.mdt.markdown.Markdown;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserDto {
    private UUID id;
    private String name;
    private String username;
    private List<Folder> folders;
    private List<Markdown> markdowns;

    public UserDto() {
    }

    public static UserDto fromEntity(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
//        dto.setMarkdowns(user.getMarkdowns());
        dto.setFolders(user.getFolders());

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public List<Markdown> getMarkdowns() {
//        return markdowns;
//    }

//    public void setMarkdowns(List<Markdown> markdowns) {
//        this.markdowns = markdowns;
//    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }
}
