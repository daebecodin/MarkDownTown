package com.daebecodin.mdt.markdown;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public interface MarkdownRepository extends JpaRepository<Markdown, UUID> {

    Optional<Markdown> findById(UUID id);
    List<Markdown> findAll();

    List<Markdown> findByTitleContaining(String title);

    @Transactional
    void deleteByUserId(UUID id);


}

