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
import com.phsecurities.susu.service.DisputeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.phsecurities.susu.model.Dispute;

@RestController 
@Tag(name = "PledgePay - Disputes", description = "Endpoints for anything PledgePay Request - dispute related in PledgePay")
@RequestMapping("/disputes")
class DisputeController {
    @Autowired 
    private DisputeService service;
    @PostMapping("/create")
    @Operation(summary = "Endpoint to create a new dispute")
    public Dispute create(@RequestBody Dispute d) { 
        return service.save(d); 
    }
    @GetMapping("/list")
    @Operation(summary = "Endpoint to list all disputes") 
    public List<Dispute> list() { 
        return service.getAll(); 
    }
    @GetMapping("/{id}") 
    @Operation(summary = "Endpoint to get a dispute by ID")
    public ResponseEntity<Dispute> get(@PathVariable UUID id) {
        return service.getAll().stream().filter(c -> c.getDisputeId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}") 
    @Operation(summary = "Endpoint to update a dispute by ID")
    public ResponseEntity<Dispute> update(@PathVariable UUID id, @RequestBody Dispute d) {
        d.setDisputeId(id); return ResponseEntity.ok(service.save(d));
    }

    @DeleteMapping("/{id}") 
    @Operation(summary = "Endpoint to delete a dispute by ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id); return ResponseEntity.noContent().build();
    }
}
