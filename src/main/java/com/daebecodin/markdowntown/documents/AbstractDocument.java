package com.daebecodin.markdowntown.documents;

import java.time.LocalDateTime;
import java.util.UUID;

public interface AbstractDocument {
    UUID getId();
    String getTitle();
    String getContent();       // raw Markdown
    String getHtml();          // rendered HTML
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
