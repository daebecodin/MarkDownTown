package com.daebecodin.markdowntown.document.markdown;

import com.daebecodin.markdowntown.document.BaseDocument;
import com.daebecodin.markdowntown.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Markdown extends BaseDocument {
    private String slugger;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    @JsonIgnore  // ← prevent Jackson from even trying to serialize the User
    private User user;

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

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }
}
