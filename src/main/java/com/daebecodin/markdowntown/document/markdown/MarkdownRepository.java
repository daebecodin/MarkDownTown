package com.daebecodin.markdowntown.document.markdown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public interface MarkdownRepository extends JpaRepository<Markdown, UUID> {
    Optional<Markdown> findById(UUID id);
    Markdown findByTitle(String title);

}
