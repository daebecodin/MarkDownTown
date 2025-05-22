package com.daebecodin.mdt.folder;

import com.daebecodin.mdt.markdown.Markdown;
import com.daebecodin.mdt.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference // to avoid circular JSON serialization
    private User user;

    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    @Column(name = "markdowns")
    private List<Markdown> markdowns = new ArrayList<>();

    public Folder() {
    }

    public Folder(UUID id, String name, User user, List<Markdown> markdowns) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.markdowns = markdowns;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void addMarkdown(Markdown markdown) {
        if (markdowns == null) markdowns = new ArrayList<>();
        markdowns.add(markdown);
        markdown.setFolder(this);
    }
    public void removeMarkdown(Markdown md) {
        markdowns.remove(md);
        md.setFolder(null);
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Folder folder = (Folder) o;
//        return Objects.equals(id, folder.id) && Objects.equals(name, folder.name) && Objects.equals(markdowns, folder.markdowns);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, markdowns);
//    }

    @Override
    public String toString() {
        return "Folder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", markdowns=" + markdowns +
                '}';
    }
}
