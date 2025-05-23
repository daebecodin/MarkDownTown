package com.daebecodin.mdt.markdown;


import com.daebecodin.mdt.document.BaseDocument;
import com.daebecodin.mdt.folder.Folder;
import com.daebecodin.mdt.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Markdown extends BaseDocument {
    private String slugger;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = true
    )

    @JoinColumn(
            name = "user_id",
            nullable = true // one doesnt need to be a user to mke a markdown
    )
    @OnDelete(
            action = OnDeleteAction.CASCADE
    )
    @JsonBackReference("user-markdowns") // reference for a users list of markdowns
    private User user;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            optional = true
    )//persist folder on creation
    @JoinColumn(
            name = "folder_id",
            nullable = true) // having folder is optional for a markdown
    @OnDelete(
            action = OnDeleteAction.CASCADE)
    @JsonBackReference(value = "folder-markdowns") // reference for a folder's list of markdowns
    private Folder folder;

    public Markdown() {

    }

    public Markdown(UUID id, String title, String content, String html, LocalDateTime createdAt, LocalDateTime updatedAt, String slugger) {
        super(id, title, content, html, createdAt, updatedAt);
        this.slugger = slugger;
    }

    public String getSlugger() {
        return slugger;
    }

    public void setSlugger(String slugger) {
        this.slugger = slugger;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }


}

