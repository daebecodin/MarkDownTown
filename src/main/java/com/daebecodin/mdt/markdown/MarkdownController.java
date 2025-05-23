package com.daebecodin.mdt.markdown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/markdowntown")
public class MarkdownController {
    private final MarkdownService markdownService;
    private final MarkdownRepository markdownRepository;


    @Autowired
    public MarkdownController(MarkdownService markdownService, MarkdownRepository markdownRepository) {
        this.markdownService = markdownService;
        this.markdownRepository = markdownRepository;
    }

    @GetMapping("/markdowns")
    public ResponseEntity<?> getAllMarkdowns() {
        List<MarkdownDto> all = markdownService.getAllMarkdowns();
        return ResponseEntity.ok(all);

    }

    @PostMapping(
            path    = "/create-new-markdown"
    )
    ResponseEntity<?> newMarkdown(@RequestBody Markdown markdown) {
        Markdown newMarkdown = markdownRepository.save(markdown);
        return new ResponseEntity<>(newMarkdown, HttpStatus.CREATED);
    }

}
