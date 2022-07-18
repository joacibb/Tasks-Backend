package ar.com.tasks.service;

import ar.com.tasks.models.Folder;
import ar.com.tasks.models.Task;
import ar.com.tasks.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderServiceImpl implements FolderService{
    @Autowired
    private FolderRepository folderRepository;

    @Override
    public void create(Folder folder) {
        folder.setId(null);
        folderRepository.save(folder);
    }

    @Override
    public Folder findByName(String s) {
        List<Folder> list = folderRepository.findAll();
        Folder toReturn = null;
        for (Folder folder : list) {
            if(folder.getName()!=null){
                if(folder.getName().equals(s))
                    toReturn = folder;
            }
        }
        return toReturn;
    }

    @Override
    public void deleteFolder(String s) {
        Folder folder = findByName(s);
        folder.deleteAllTask();
        folderRepository.delete(folder);
    }

    public List<Folder> findAll(){
        return folderRepository.findAll();
    }
}
