package com.daebecodin.markdowntown.document.markdown;


import com.daebecodin.markdowntown.document.markdown.dto.MarkdownDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "markdowns")
public class MarkdownController {
    private final MarkdownService markdownService;


    @Autowired
    public MarkdownController(MarkdownService markdownService) {
        this.markdownService = markdownService;
    }

    @GetMapping("all")
    public List<MarkdownDto> getAll() {
        return markdownService.findAll().stream()
                .map(md -> {
                    MarkdownDto dto = new MarkdownDto();
                    dto.setId(md.getId());
                    dto.setTitle(md.getTitle());
                    dto.setContent(md.getContent());
                    return dto;
                })
                .toList();

    }
}
