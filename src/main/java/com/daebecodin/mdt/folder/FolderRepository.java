package com.daebecodin.mdt.folder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface FolderRepository extends JpaRepository<Folder, UUID> {

    List<Folder> findAll();
    List<Folder> findAllByName(String name);
    List<Folder> findByName(String name);
    Optional<Folder> findById(UUID id);

    long count();

    void delete(Folder folder);
    void deleteById(Folder folder);

    boolean existsById(UUID id);







}
