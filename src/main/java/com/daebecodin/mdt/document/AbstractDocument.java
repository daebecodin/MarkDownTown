package com.daebecodin.mdt.document;

import java.time.LocalDateTime;
import java.util.UUID;

interface AbstractDocument {
    UUID getId();
    String getTitle();
    String getContent();       // raw Markdown
    String getHtml();          // rendered HTML
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
