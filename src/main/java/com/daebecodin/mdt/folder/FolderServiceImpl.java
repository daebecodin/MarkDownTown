package com.daebecodin.mdt.folder;

import com.daebecodin.mdt.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FolderServiceImpl implements FolderService {
    private final FolderRepository folderRepository;
    private final UserRepository userRepository;

    public FolderServiceImpl(FolderRepository folderRepository, UserRepository userRepository) {
        this.folderRepository = folderRepository;
        this.userRepository = userRepository;
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

    @Override
    public void deleteFolderById(UUID id) {
        folderRepository.findById(id).ifPresentOrElse(folderRepository::delete,() -> {
            throw new FolderNotFoundException(id);
        });
    }

}
