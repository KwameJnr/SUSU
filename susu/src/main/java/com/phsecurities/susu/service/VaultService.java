package com.phsecurities.susu.service;

import java.util.List;
import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phsecurities.susu.model.PersonalSavingsVault;
import com.phsecurities.susu.repository.PersonalSavingsVaultRepository;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public 
class VaultService {
    private final PersonalSavingsVaultRepository repo;

    // @Autowired 
    public VaultService(PersonalSavingsVaultRepository repo) { 
        this.repo = repo; 
    }

    public PersonalSavingsVault save(PersonalSavingsVault v) { 
        return repo.save(v); 
    }
    public List<PersonalSavingsVault> getAll() { 
        return repo.findAll(); 
    }
    public void deleteById(UUID id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Vault with ID " + id + " not found.");
        }
        repo.deleteById(id);
    }
}
