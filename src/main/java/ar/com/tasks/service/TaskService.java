package ar.com.tasks.service;

import ar.com.tasks.models.Task;

public interface TaskService {

    Task findByID(Long id);

    void create(Task task);

    void update(Long id, Task task);

    void delete(Long id);

    void mark(Long id);
}
