package com.daebecodin.markdowntown.document.markdown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface MarkdownRepository extends JpaRepository<Markdown, UUID> {

    // all markdowns by a given user
    List<Markdown> findByUserId(UUID id);

    // optionally get a single markdown by id and user
    Markdown findByTitle(String title);

}
