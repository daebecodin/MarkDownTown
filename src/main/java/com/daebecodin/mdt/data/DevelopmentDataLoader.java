package com.daebecodin.mdt.data;


import com.daebecodin.mdt.folder.Folder;
import com.daebecodin.mdt.folder.FolderRepository;
import com.daebecodin.mdt.markdown.Markdown;
import com.daebecodin.mdt.markdown.MarkdownRepository;
import com.daebecodin.mdt.user.User;
import com.daebecodin.mdt.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("development")
@Component
public class DevelopmentDataLoader extends DataLoader {
    private UserRepository userRepository;
    private MarkdownRepository markdownRepository;
    private FolderRepository folderRepository;

    @Autowired
    public DevelopmentDataLoader(UserRepository userRepository, MarkdownRepository markdownRepository, FolderRepository folderRepository) {
        this.userRepository = userRepository;
        this.markdownRepository = markdownRepository;
        this.folderRepository = folderRepository;
    }

    @Transactional
    @Override
    public void loadMarkDownSpecificData() {
        System.out.println("🔄 DataLoader running");

        // 1) Alice
        User alice = new User();
        alice.setName("Alice");
        alice.setUsername("alice");
        alice.setPassword("password");
        userRepository.save(alice);

        Markdown note1 = new Markdown();
        note1.setTitle("First Note");
        note1.setContent("# Hello Alice");
        note1.setSlugger("first-note");
        note1.setUser(alice);
        markdownRepository.save(note1);

        Folder folder1 = new Folder();
        folder1.setName("random folder");
        folder1.setUser(alice);
        folder1.addMarkdown(note1);
        folderRepository.save(folder1);

        // 2) Bob
        User bob = new User();
        bob.setName("Bob");
        bob.setUsername("bob");
        bob.setPassword("hunter2");
        userRepository.save(bob);

        Markdown note2 = new Markdown();
        note2.setTitle("Bob's Thoughts");
        note2.setContent("## Bob’s first markdown note");
        note2.setSlugger("bobs-thoughts");
        note2.setUser(bob);
        markdownRepository.save(note2);

        Folder folder2 = new Folder();
        folder2.setName("bob-folder");
        folder2.setUser(bob);
        folder2.addMarkdown(note2);
        folderRepository.save(folder2);

        // 3) Carol
        User carol = new User();
        carol.setName("Carol");
        carol.setUsername("carol");
        carol.setPassword("s3cr3t");
        userRepository.save(carol);

        Markdown note3 = new Markdown();
        note3.setTitle("Carol’s Guide");
        note3.setContent("* Bullet 1\n* Bullet 2\n");
        note3.setSlugger("carols-guide");
        note3.setUser(carol);
        markdownRepository.save(note3);

        Folder folder3 = new Folder();
        folder3.setName("guides");
        folder3.setUser(carol);
        folder3.addMarkdown(note3);
        folderRepository.save(folder3);

        // 4) Dave
        User dave = new User();
        dave.setName("Dave");
        dave.setUsername("dave");
        dave.setPassword("letmein");
        userRepository.save(dave);

        Markdown note4 = new Markdown();
        note4.setTitle("Dave’s Checklist");
        note4.setContent("1. Item one\n2. Item two\n");
        note4.setSlugger("daves-checklist");
        note4.setUser(dave);
        markdownRepository.save(note4);

        Folder folder4 = new Folder();
        folder4.setName("checklists");
        folder4.setUser(dave);
        folder4.addMarkdown(note4);
        folderRepository.save(folder4);

        // 5) Eve
        User eve = new User();
        eve.setName("Eve");
        eve.setUsername("eve");
        eve.setPassword("qwerty");
        userRepository.save(eve);

        Markdown note5 = new Markdown();
        note5.setTitle("Eve’s Notes");
        note5.setContent("> A blockquote from Eve");
        note5.setSlugger("eves-notes");
        note5.setUser(eve);
        markdownRepository.save(note5);

        Folder folder5 = new Folder();
        folder5.setName("quotes");
        folder5.setUser(eve);
        folder5.addMarkdown(note5);
        folderRepository.save(folder5);

        // 6) Frank
        User frank = new User();
        frank.setName("Frank");
        frank.setUsername("frank");
        frank.setPassword("123456");
        userRepository.save(frank);

        Markdown note6 = new Markdown();
        note6.setTitle("Frank’s Journal");
        note6.setContent("Some **bold** text and _italics_");
        note6.setSlugger("franks-journal");
        note6.setUser(frank);
        markdownRepository.save(note6);

        Folder folder6 = new Folder();
        folder6.setName("journals");
        folder6.setUser(frank);
        folder6.addMarkdown(note6);
        folderRepository.save(folder6);
    }


}
