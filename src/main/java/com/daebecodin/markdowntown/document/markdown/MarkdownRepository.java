package com.daebecodin.markdowntown.document.markdown;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MarkdownRepository extends JpaRepository<Markdown, Long> {
    Markdown findMarkdownByTitle(String title);
    Markdown findMarkdownById(UUID id);
}
