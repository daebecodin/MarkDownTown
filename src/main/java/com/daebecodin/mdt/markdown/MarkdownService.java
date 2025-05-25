package com.daebecodin.mdt.markdown;

import com.daebecodin.mdt.folder.FolderDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public  interface MarkdownService {
    List<MarkdownDto> getAllMarkdowns();
    Optional<MarkdownDto> getMarkdownById(UUID id);
    Optional<MarkdownDto> updateMarkdownById(UUID id, MarkdownDto updatedMarkdown);
    void deleteMarkdownById(UUID id);

}
