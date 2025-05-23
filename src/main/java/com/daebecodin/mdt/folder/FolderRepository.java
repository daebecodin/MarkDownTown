package com.daebecodin.mdt.folder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FolderRepository extends JpaRepository<Folder, UUID> {

    List<Folder> findAll();
    Optional<Folder> findById(UUID id);
    List<Folder> findByNameContaining(String name);

    long count();

    void delete(Folder folder);
    void deleteById(UUID id);

    boolean existsById(UUID id);






}
