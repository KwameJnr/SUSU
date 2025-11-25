package com.phsecurities.susu.service;

import java.util.List;
import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phsecurities.susu.model.VaultContribution;
import com.phsecurities.susu.repository.VaultContributionRepository;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public 
class VaultContributionService {
    private final VaultContributionRepository repo;

    // @Autowired 
    public VaultContributionService(VaultContributionRepository repo) { 
        this.repo = repo; 
    }

    public VaultContribution save(VaultContribution vc) { 
        return repo.save(vc); 
    }
    public List<VaultContribution> getAll() { 
        return repo.findAll(); 
    }
    public void deleteById(UUID id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("VaultContribution with ID " + id + " not found.");
        }
        repo.deleteById(id);
    }
}
