package com.daebecodin.mdt.markdown;

import java.util.UUID;

public class MarkdownNotFoundException extends RuntimeException{
    public MarkdownNotFoundException(UUID id) {
        super("could not find markdown " + id);
    }
}
