package com.daebecodin.markdowntown.document.markdown;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface MarkdownRepository extends JpaRepository<Markdown, Long> {

    // all markdowns by a given user
    List<Markdown> findByUserId(Long userId);

//    List<Markdown> findByName(String name);

    // optionally get a single markdown by id and user
    List<Markdown> findByTitleContaining(String title);


    @Transactional
    void deleteByUserId(Long id);


}
