package com.daebecodin.mdt.folder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/markdowntown/folders")
public class FolderController {

    private final FolderService folderService;
    private final FolderRepository folderRepository;

    @Autowired
    public FolderController(FolderService folderService, FolderRepository folderRepository) {
        this.folderService = folderService;
        this.folderRepository = folderRepository;
    }


    @GetMapping(value = "")
    public ResponseEntity<List<FolderDto>> getAllFolders() {
        List<FolderDto> all = folderService.getAllFolders();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getFolderById(@PathVariable UUID id) {
        return folderService.getFolderById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value =  "/create-new-folder")
    public ResponseEntity<?> creatFolder(@RequestBody Folder folder){
        Folder newFolder = folderRepository.save(folder);
        return new ResponseEntity<>(newFolder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}/update-folder")
    public ResponseEntity<FolderDto>updateFolderById(@PathVariable UUID id, @RequestBody FolderDto folder) {

       return folderService.updateFolderById(id, folder)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());


    }

    @DeleteMapping(value = "/{id}/delete-folder")
    public ResponseEntity<String> deleteFolderById(@PathVariable UUID id) {
        folderService.deleteFolderById(id);
        return new ResponseEntity<>("Folder " + id + " Has Been Deleted", HttpStatus.OK);
    }
}
