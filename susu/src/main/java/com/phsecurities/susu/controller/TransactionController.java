package com.phsecurities.susu.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.phsecurities.susu.service.TransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.phsecurities.susu.model.Transaction;

@RestController 
@Tag(name = "PledgePay - Transactions", description = "Endpoints for anything PledgePay Request - transactions related in PledgePay")
@RequestMapping("/transactions")
class TransactionController {
    @Autowired 
    private TransactionService service;
    @PostMapping("/create")
    @Operation(summary = "Endpoint to create a new transaction")
    public Transaction create(@RequestBody Transaction t) { 
        return service.save(t); 
    }
    @GetMapping("/list")
    @Operation(summary = "Endpoint to list all transactions")
    public List<Transaction> list() { 
        return service.getAll(); 
    }

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint to get a transaction by ID")
    public ResponseEntity<Transaction> get(@PathVariable UUID id) {
        return service.getAll().stream().filter(c -> c.getTransactionId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Endpoint to update a transaction by ID")
    public ResponseEntity<Transaction> update(@PathVariable UUID id, @RequestBody Transaction t) {
        t.setTransactionId(id); return ResponseEntity.ok(service.save(t));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint to delete a transaction by ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id); return ResponseEntity.noContent().build();
    }
}
