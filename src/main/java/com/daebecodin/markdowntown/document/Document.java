package com.daebecodin.markdowntown.document;

import java.time.LocalDateTime;
import java.util.UUID;

interface AbstractDocument {
    Long getId();
    String getTitle();
    String getContent();       // raw Markdown
    String getHtml();          // rendered HTML
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
