package com.daebecodin.markdowntown.markdown.documents;

import java.time.LocalDateTime;
import java.util.UUID;

public interface Document {
    UUID getId();
    String getTitle();
    String getContent();       // raw Markdown
    String getHtml();          // rendered HTML
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
