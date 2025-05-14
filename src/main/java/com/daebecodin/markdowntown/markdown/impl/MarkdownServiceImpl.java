package com.daebecodin.markdowntown.markdown.impl;

import com.daebecodin.markdowntown.markdown.Markdown;
import com.daebecodin.markdowntown.markdown.MarkdownService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkdownServiceImpl implements MarkdownService {
    private List<Markdown> markdowns = new ArrayList<>();

    @Override
    public List<Markdown> findAll() {
        return List.of();
    }

    @Override
    public void createMarkdown(Markdown markdown) {
        markdowns.add(markdown);
    }
}
