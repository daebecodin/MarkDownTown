package com.daebecodin.mdt.markdown;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public  interface MarkdownService {
    List<MarkdownDto> getAllMarkdowns();
    List<MarkdownDto> getMarkdownById(UUID id);
}
