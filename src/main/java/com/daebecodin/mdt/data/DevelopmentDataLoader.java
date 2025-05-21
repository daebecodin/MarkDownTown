package com.daebecodin.mdt.data;

import com.daebecodin.mdt.markdown.Markdown;
import com.daebecodin.mdt.markdown.MarkdownRepository;
import com.daebecodin.mdt.user.User;
import com.daebecodin.mdt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("development")
@Component
public class DevelopmentDataLoader extends DataLoader {
    private  UserRepository userRepository;
    private  MarkdownRepository markdownRepopsitory;

    @Autowired
    public DevelopmentDataLoader(UserRepository userRepository, MarkdownRepository markdownRepository) {
        this.userRepository = userRepository;
        this.markdownRepopsitory = markdownRepository;
    }

    @Override
    public void loadMarkDownSpecificData() {
        System.out.println("🔄 DataLoader running");
        // 1) create a User
        User alice = new User();
        alice.setName("Alice");
        alice.setUsername("alice");
        alice.setPassword("password");
        alice.getCreatedAt();
        alice.getUpdatedAt();
        userRepository.save(alice);

        // 2) create a Markdown note for Alice
        Markdown note = new Markdown();
        note.setTitle("First Note");
        note.setContent("# Hello Alice");
        note.setSlugger("first-note");
        note.getCreatedAt();
        note.getUpdatedAt();
        note.setUser(alice);
        markdownRepopsitory.save(note);
    }

}
