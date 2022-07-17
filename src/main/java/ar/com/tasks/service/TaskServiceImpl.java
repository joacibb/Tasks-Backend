package ar.com.tasks.service;

import ar.com.tasks.exceptions.ObjectNotFoundException;
import ar.com.tasks.models.Task;
import ar.com.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public Task findByID(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElseThrow(
                () ->
                        new ObjectNotFoundException(
                                "Note not found - ID: " +
                                        id +
                                        " Type: " +
                                        Task.class.getName()
                        )
        );
    }

    @Override
    public void create(Task task) {
        task.setId(null);
        taskRepository.save(task);
    }

    @Override
    public void update(Long id, Task task) {
        try{
        Task oldTask = taskRepository.findById(id).orElse(null);
        oldTask.setMark(task.getMark());
        oldTask.setTitle(task.getTitle());
        taskRepository.save(oldTask);
        }
        catch (Exception e){
            throw new ObjectNotFoundException("Note not found - ID: " +
                    id +
                    " Type: " +
                    Task.class.getName()
            );
        }
    }

    @Override
    public void delete(Long id) {
        try{
            Task task = taskRepository.findById(id).orElse(null);
            taskRepository.delete(task);
        }
        catch (Exception e){
            throw new ObjectNotFoundException("Note not found - ID: " +
                    id +
                    " Type: " +
                    Task.class.getName()
            );
        }
    }
}
