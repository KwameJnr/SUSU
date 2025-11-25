package com.phsecurities.susu.service;

import java.util.List;
import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phsecurities.susu.model.Contribution;
import com.phsecurities.susu.repository.ContributionRepository;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public 
class ContributionService {
    private final ContributionRepository repo;

    // @Autowired 
    public ContributionService(ContributionRepository repo) { 
        this.repo = repo; 
    }
    public Contribution save(Contribution c) { 
        return repo.save(c);
     }
    public List<Contribution> getAll() { 
        return repo.findAll(); 
    }
    
    public void deleteById(UUID id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Contribution with ID " + id + " not found.");
        }
        repo.deleteById(id);
    }
}
