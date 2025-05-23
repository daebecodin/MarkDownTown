package com.daebecodin.mdt.user;

import com.daebecodin.mdt.folder.Folder;

import com.daebecodin.mdt.markdown.Markdown;
import com.daebecodin.mdt.person.Person;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Person {
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "user-folders") // reference for users list of folders
    private List<Folder> folders = new ArrayList<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @JsonManagedReference(value = "user-markdowns") // reference for users lost of markdowns
    private List<Markdown>  markdowns = new ArrayList<>();

    public void addFolder(Folder folder) {
        folders.add(folder);
        folder.setUser(this);
    }

    public void removeFolder(Folder folder) {
        folders.remove(folder);
        folder.setUser(null);
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folder) {
        this.folders = folder;
    }

    public List<Markdown> getMarkdowns() {
        return markdowns;
    }

    public void setMarkdowns(List<Markdown> markdowns) {
        this.markdowns = markdowns;
    }
}


