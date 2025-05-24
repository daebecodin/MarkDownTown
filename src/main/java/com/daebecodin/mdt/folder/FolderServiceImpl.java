package com.daebecodin.mdt.folder;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
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

    @Override
    public Optional<FolderDto> updateFolderById(UUID id, FolderDto updatedFolder) {
        return folderRepository.findById(id)
                .map(existingFolder -> {
                    existingFolder.setName(updatedFolder.getName());
                    Folder saved = folderRepository.save(existingFolder);
                    return FolderDto.fromEntity(saved);
                });
    }

}
