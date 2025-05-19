package com.daebecodin.markdowntown.document.markdown;

import com.daebecodin.markdowntown.document.markdown.dto.MarkdownDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public  interface MarkdownService {

List<MarkdownDto> getMarkdownById(Long id);
}
