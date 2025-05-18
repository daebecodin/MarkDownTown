package com.daebecodin.markdowntown.document.markdown.config;

import com.daebecodin.markdowntown.document.markdown.Markdown;
import com.daebecodin.markdowntown.document.markdown.MarkdownRepository;
import com.daebecodin.markdowntown.user.User;
import com.daebecodin.markdowntown.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepo;
    private final MarkdownRepository mdRepo;

    public DataLoader(UserRepository userRepo, MarkdownRepository mdRepo) {
        this.userRepo = userRepo;
        this.mdRepo   = mdRepo;
    }

    @Override
    public void run(String... args) {
        // 1) create a User
        User alice = new User();
        alice.setName("Alice");
        alice.setUsername("alice");
        alice.setPassword("password");
        userRepo.save(alice);

        // 2) create a Markdown note for Alice
        Markdown note = new Markdown();
        note.setTitle("First Note");
        note.setContent("# Hello Alice");
        note.setSlugger("first-note");
        note.setUser(alice);
        mdRepo.save(note);
    }
}