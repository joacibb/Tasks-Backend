package ar.com.tasks.controller;

import ar.com.tasks.models.Task;
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

    //**********************| GET |********************************
    @GetMapping(value="/task/{id}")
    public Task findByID(@PathVariable("id") Long idTask){
        return taskService.findByID(idTask);
    }

    //**********************| POST |********************************
    @JsonManagedReference
    @PostMapping(value="/task")
    public void create(@RequestBody Task task){
        taskService.create(task);
    }

    //**********************| PUT |**********************************

    @PutMapping(value="/task/{id}")
    public void update(@PathVariable("id") Long idTask,@RequestBody Task task){
        taskService.update(idTask,task);
    }

    @PutMapping(value="/task/mark/{id}")
    public void mark(@PathVariable("id") Long idTask){
        taskService.mark(idTask);
    }
    //**********************| DELETE |********************************

    @DeleteMapping(value="/task/{id}")
    public void delete(@PathVariable("id") Long idTask){
        taskService.delete(idTask);
    }

}
