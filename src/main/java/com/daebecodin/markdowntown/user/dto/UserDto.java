package com.daebecodin.markdowntown.user.dto;

import com.daebecodin.markdowntown.document.markdown.Markdown;
import com.daebecodin.markdowntown.user.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private List<Markdown> markdowns;

    public static UserDto fromEntity(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setMarkdowns(user.getMarkdowns());

        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Markdown> getMarkdowns() {
        return markdowns;
    }

    public void setMarkdowns(List<Markdown> markdowns) {
        this.markdowns = markdowns;
    }
}
