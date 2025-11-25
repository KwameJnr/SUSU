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
import com.phsecurities.susu.service.ContributionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.phsecurities.susu.model.Contribution;

@RestController 
@Tag(name = "PledgePay - Contributions", description = "Endpoints for anything PledgePay Request - contribution related in PledgePay")
@RequestMapping("/contributions")
class ContributionController {
    @Autowired 
    private ContributionService service;

    @PostMapping("/create") 
    @Operation(summary = "Endpoint to create a new contribution")
    public Contribution create(@RequestBody Contribution c) { 
        return service.save(c); 
    }
    @GetMapping("/list") 
    @Operation(summary = "Endpoint to list all contributions")
    public List<Contribution> list() { 
        return service.getAll(); 
    }

    @GetMapping("/{id}") 
    @Operation(summary = "Endpoint to get a contribution by ID")
    public ResponseEntity<Contribution> get(@PathVariable UUID id) {
        return service.getAll().stream().filter(c -> c.getContributionId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}") 
    @Operation(summary = "Endpoint to update a contribution by ID")
    public ResponseEntity<Contribution> update(@PathVariable UUID id, @RequestBody Contribution u) {
        u.setContributionId(id); return ResponseEntity.ok(service.save(u));
    }

    @DeleteMapping("/{id}") 
    @Operation(summary = "Endpoint to delete a contribution by ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id); return ResponseEntity.noContent().build();
    }
}
