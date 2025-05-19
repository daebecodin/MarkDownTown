package com.daebecodin.markdowntown.document.markdown;

import com.daebecodin.markdowntown.document.BaseDocument;
import com.daebecodin.markdowntown.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Markdown extends BaseDocument {
    private String slugger;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
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


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }
}
