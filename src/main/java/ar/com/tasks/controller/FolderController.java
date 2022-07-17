package ar.com.tasks.controller;

import ar.com.tasks.models.Folder;
import ar.com.tasks.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value ="/api")
public class FolderController {
    @Autowired
    private FolderService folderService;

    @PostMapping
    public void createFolder(@RequestBody Folder folder){
        folderService.create(folder);
    }

}
