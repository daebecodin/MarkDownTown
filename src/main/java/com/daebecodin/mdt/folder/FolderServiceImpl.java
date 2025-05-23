package com.daebecodin.mdt.folder;

import com.daebecodin.mdt.markdown.MarkdownDto;
import com.daebecodin.mdt.markdown.MarkdownRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class FolderServiceImpl implements FolderService {
    private final FolderRepository folderRepository;

    public FolderServiceImpl(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    @Override
    public List<FolderDto> getAllFolders() {
        return folderRepository.findAll()
                .stream()
                .map(FolderDto::fromEntity)
                .toList();
    }

    @Override
    public Optional<FolderDto> getFolderById(UUID id) {
        return folderRepository.findById(id)
                .map(FolderDto::fromEntity);
    }
}
