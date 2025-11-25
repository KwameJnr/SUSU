package com.phsecurities.susu.service;

import java.util.List;
import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phsecurities.susu.model.Dispute;
import com.phsecurities.susu.repository.DisputeRepository;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public 
class DisputeService {
    private final DisputeRepository repo;

    // @Autowired 
    public DisputeService(DisputeRepository repo) { 
        this.repo = repo; 
    }

    public Dispute save(Dispute d) { 
        return repo.save(d); 
    }
    public List<Dispute> getAll() { 
        return repo.findAll(); 
    }
    
    public void deleteById(UUID id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Dispute with ID " + id + " not found.");
        }
        repo.deleteById(id);
    }
}
