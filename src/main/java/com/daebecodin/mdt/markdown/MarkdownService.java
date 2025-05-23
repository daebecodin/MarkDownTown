package com.daebecodin.mdt.markdown;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public  interface MarkdownService {
    List<MarkdownDto> getAllMarkdowns();
    Optional<MarkdownDto> getMarkdownById(UUID id);
}
