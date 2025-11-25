package com.phsecurities.susu.service;

import java.util.List;
import java.util.UUID;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phsecurities.susu.model.Transaction;
import com.phsecurities.susu.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service 
@Transactional
public 
class TransactionService {
    private final TransactionRepository repo;

    // @Autowired 
    public TransactionService(TransactionRepository repo) { 
        this.repo = repo; 
    }

    public Transaction save(Transaction t) { 
        return repo.save(t); 
    }
    public List<Transaction> getAll() { 
        return repo.findAll(); 
    }
    public void deleteById(UUID id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Transaction with ID " + id + " not found.");
        }
        repo.deleteById(id);
    }
}
