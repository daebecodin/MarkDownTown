package com.daebecodin.mdt;

import com.daebecodin.mdt.markdown.Markdown;
import com.daebecodin.mdt.markdown.MarkdownRepository;
import com.daebecodin.mdt.user.User;
import com.daebecodin.mdt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepo;
    private final MarkdownRepository mdRepo;

    @Autowired
    public DataLoader(UserRepository userRepo, MarkdownRepository mdRepo) {
        this.userRepo = userRepo;
        this.mdRepo   = mdRepo;
    }

    @Override
    public void run(String... args) {
        System.out.println("🔄 DataLoader running");
        // 1) create a User
        User alice = new User();
        alice.setName("Alice");
        alice.setUsername("alice");
        alice.setPassword("password");
        alice.getCreatedAt();
        alice.getUpdatedAt();
        userRepo.save(alice);

        // 2) create a Markdown note for Alice
        Markdown note = new Markdown();
        note.setTitle("First Note");
        note.setContent("# Hello Alice");
        note.setSlugger("first-note");
        note.getCreatedAt();
        note.getUpdatedAt();
        note.setUser(alice);
        mdRepo.save(note);
    }
}