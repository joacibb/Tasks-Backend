package ar.com.tasks.repository;


import ar.com.tasks.models.Folder;
import ar.com.tasks.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder,Long> {
}

