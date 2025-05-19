package com.daebecodin.markdowntown.markdown;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class MarkdownServiceImpl implements MarkdownService{

    private final MarkdownRepository markdownRepository;

    @Autowired
    public MarkdownServiceImpl(MarkdownRepository markdownRepository) {
        this.markdownRepository = markdownRepository;
    }

    @Override
    public List<MarkdownDto> getMarkdownById(UUID userId) {
        return markdownRepository.findByUserId(userId)
                .stream()
                .map(MarkdownDto::fromEntity)
                .collect(Collectors.toList());
    }
}
