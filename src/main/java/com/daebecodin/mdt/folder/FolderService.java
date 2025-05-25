package com.daebecodin.mdt.folder;

import com.daebecodin.mdt.markdown.MarkdownDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface FolderService {
    List<FolderDto> getAllFolders();
    Optional<FolderDto> getFolderById(UUID id);
    Optional<FolderDto> updateFolderById( UUID id, FolderDto updatedFolder);
    void deleteFolderById(UUID id);


}
