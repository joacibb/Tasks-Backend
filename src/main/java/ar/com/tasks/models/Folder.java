package ar.com.tasks.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany
    List<Task> tasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTask(Task task){
        if(task!=null){
        tasks.add(task);}
    }

    public void deleteTask(Task task){
        tasks.removeIf(task1 -> task1.equals(task));
    }

    public void deleteAllTask(){
        for (Task task : tasks) {
            tasks.remove(task);
        }
    }

    public List<Task> getTasks(){
        return tasks;
    }
}
