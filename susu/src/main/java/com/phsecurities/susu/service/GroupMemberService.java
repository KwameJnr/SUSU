package com.phsecurities.susu.service;

import java.util.List;
import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phsecurities.susu.model.GroupMember;
import com.phsecurities.susu.repository.GroupMemberRepository;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public 
class GroupMemberService {
    private final GroupMemberRepository repo;

    // @Autowired 
    public GroupMemberService(GroupMemberRepository repo) { 
        this.repo = repo; 
    }
    public GroupMember save(GroupMember gm) { 
        return repo.save(gm);
     }
    public List<GroupMember> getAll() { 
        return repo.findAll(); 
    }
    
    public void deleteById(UUID id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("GroupMember with ID " + id + " not found.");
        }
        repo.deleteById(id);
    }
}
