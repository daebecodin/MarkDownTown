package com.daebecodin.markdowntown.document.markdown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MarkdownService {

    private final MarkdownRepository markdownRepository;

    @Autowired
    public MarkdownService(MarkdownRepository markdownRepository) {
        this.markdownRepository = markdownRepository;
    }

    public List<Markdown> findAll() {
        return markdownRepository.findAll();
    }




}
