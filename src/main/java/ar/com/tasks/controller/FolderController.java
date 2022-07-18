package ar.com.tasks.controller;

import ar.com.tasks.models.Folder;
import ar.com.tasks.models.Task;
import ar.com.tasks.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value ="/api")
public class FolderController {
    @Autowired
    private FolderService folderService;

    @PostMapping(value="/folders")
    public void createFolder(@RequestBody Folder folder){
        folderService.create(folder);
    }

    @GetMapping(value="/folders")
    public List<Folder> getAll(){return folderService.findAll();}

    @GetMapping(value="/folders/{nameFolder}")
    public List<Task> viewItems(@PathVariable("nameFolder") String folderName){
        Folder folder = folderService.findByName(folderName);
        return folder.getTasks();
    }

}
