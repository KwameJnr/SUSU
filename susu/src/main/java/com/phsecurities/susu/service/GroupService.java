package com.phsecurities.susu.service;

import java.util.List;
import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phsecurities.susu.model.Group;
import com.phsecurities.susu.repository.GroupRepository;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public
 class GroupService {
    private final GroupRepository repo;
    
    // @Autowired 
    public GroupService(GroupRepository repo) {
         this.repo = repo;
         }

    public Group save(Group g) { 
        return repo.save(g); 
    }

    public List<Group> getAll() {
         return repo.findAll();
    }
    public void deleteById(UUID id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Group with ID " + id + " not found.");
        }
        repo.deleteById(id);
    }
}
