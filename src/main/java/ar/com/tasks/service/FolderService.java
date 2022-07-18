package ar.com.tasks.service;

import ar.com.tasks.models.Folder;

import java.util.List;

public interface FolderService {

    void create(Folder folder);
    Folder findByName(String s);

    void deleteFolder(String s);

    List<Folder> findAll();
}
