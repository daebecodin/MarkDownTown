package com.daebecodin.mdt.folder;

import java.util.UUID;

public class FolderNotFoundException extends RuntimeException{
    public FolderNotFoundException(UUID id) {super("could not find folder " + id);}
}
