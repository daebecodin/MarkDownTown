package com.daebecodin.markdowntown.user;
import com.daebecodin.markdowntown.markdown.Markdown;
import com.daebecodin.markdowntown.person.Person;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends Person {
    @OneToMany(
            mappedBy = "user", // user fields in BaseDocument class
            cascade = CascadeType.ALL ,// remove markdown along with user
            orphanRemoval = true, // delete markdown if removed from the list
            fetch = FetchType.LAZY // prevents markdowns from being loaded when user is loaded
    )
    private List<Markdown> markdowns = new ArrayList<>();

    public List<Markdown> getMarkdowns() {
        return markdowns;
    }

    public void setMarkdowns(List<Markdown> markdowns) {
        this.markdowns = markdowns;
    }

    public void addMarkdown(Markdown markdown) {
        markdowns.add(markdown);
        markdown.setUser(this);
    }

    public void deleteMarkdown(Markdown markdown) {
        markdowns.remove(markdown);
        markdown.setUser(null);
    }


}

