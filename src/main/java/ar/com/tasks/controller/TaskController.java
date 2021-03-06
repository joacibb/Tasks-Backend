package ar.com.tasks.controller;

import ar.com.tasks.models.Folder;
import ar.com.tasks.models.Task;
import ar.com.tasks.service.FolderService;
import ar.com.tasks.service.TaskService;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value ="/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private FolderService folderService;


    //**********************| POST |********************************
    @JsonManagedReference
    @PostMapping(value="/folders/{folder}")
    public void create(@PathVariable String folder,@RequestBody Task task){
       Folder folder1 = folderService.findByName(folder);
        taskService.create(folder1,task);
    }

    //**********************| PUT |**********************************

    @PutMapping(value="/folders/{folder}/{id}")
    public void update(@PathVariable("id") Long idTask,@PathVariable("folder") String folder,@RequestBody Task task){
        if(folderService.findByName(folder).getTask(idTask)!=null){
        taskService.update(idTask,task);}
    }

    @PutMapping(value="/folders/{folder}/mark/{id}")
    public void mark(@PathVariable("id") Long idTask){
        taskService.mark(idTask);
    }
    //**********************| DELETE |********************************

    @DeleteMapping(value="/folders/{folder}/{id}")
    public void delete(@PathVariable("id") Long idTask){
        taskService.delete(idTask);
    }

}
