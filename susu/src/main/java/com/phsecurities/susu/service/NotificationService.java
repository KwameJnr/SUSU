package com.phsecurities.susu.service;

import java.util.List;
import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phsecurities.susu.model.Notification;
import com.phsecurities.susu.repository.NotificationRepository;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public 
class NotificationService {
    private final NotificationRepository repo;

    // @Autowired 
    public NotificationService(NotificationRepository repo) { 
        this.repo = repo; 
    }

    public Notification save(Notification n) { 
        return repo.save(n); 
    }
    public List<Notification> getAll() { 
        return repo.findAll(); 
    }
    public void deleteById(UUID id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Notification with ID " + id + " not found.");
        }
        repo.deleteById(id);
    }
}