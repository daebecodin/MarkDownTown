package com.daebecodin.mdt.markdown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/markdowntown")
public class MarkdownController {
    private final MarkdownService markdownService;
    private final MarkdownRepository markdownRepository;


    @Autowired
    public MarkdownController(MarkdownService markdownService, MarkdownRepository markdownRepository) {
        this.markdownService = markdownService;
        this.markdownRepository = markdownRepository;
    }


    /**
     * all markdowns
     */
    @GetMapping(
            value = "/markdowns"
    )
    public ResponseEntity<?> getAllMarkdowns() {
        List<MarkdownDto> all = markdownService.getAllMarkdowns();
        return ResponseEntity.ok(all);
    }

    /**
     * markdown by id
     */
    @GetMapping(
            value = "/markdowns/{id}"
    )
    public ResponseEntity<?> getMarkdownById(@PathVariable UUID id) {
     return markdownService.getMarkdownById(id)
             .map(ResponseEntity::ok)
             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * create new markdown
     */
    @PostMapping(
            value    = "/create-new-markdown"
    )
    ResponseEntity<?> newMarkdown(@RequestBody Markdown markdown) {
        Markdown newMarkdown = markdownRepository.save(markdown);
        return new ResponseEntity<>(newMarkdown, HttpStatus.CREATED);
    }

}
