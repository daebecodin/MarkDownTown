package com.daebecodin.mdt.markdown;


import com.daebecodin.mdt.document.BaseDocument;
import com.daebecodin.mdt.folder.Folder;
import com.daebecodin.mdt.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Markdown extends BaseDocument {
    private String slugger;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST,  optional = true)//persist folder on creation
    @JoinColumn(name = "folder_id", nullable = true) // folder is optional for a markdown
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Folder folder;

    public Markdown() {

    }

    public Markdown(String s) {
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

