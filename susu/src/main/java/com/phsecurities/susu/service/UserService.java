package com.phsecurities.susu.service;

import java.util.List;
// import java.util.Optional;
// import java.util.UUID;
import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phsecurities.susu.model.User;
import com.phsecurities.susu.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public 
class UserService {
    private final UserRepository repo;

    // @Autowired 
    public UserService(UserRepository repo) { 
        this.repo = repo; 
    }
    
    public User save(User u) { 
        return repo.save(u); 
    }

    public List<User> getAll() { 
        return repo.findAll(); 
    }

    public void deleteById(UUID id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("PerDiem with ID " + id + " not found.");
        }
        repo.deleteById(id);
    }
}