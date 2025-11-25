package com.phsecurities.susu.service;

import java.util.List;
import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phsecurities.susu.model.Payout;
import com.phsecurities.susu.repository.PayoutRepository;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public 
class PayoutService {
    private final PayoutRepository repo;

    // @Autowired 
    public PayoutService(PayoutRepository repo) { 
        this.repo = repo; 
    }

    public Payout save(Payout p) { 
        return repo.save(p); 
    }
    public List<Payout> getAll() { 
        return repo.findAll(); 
    }
    public void deleteById(UUID id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Payout with ID " + id + " not found.");
        }
        repo.deleteById(id);
    }
}
