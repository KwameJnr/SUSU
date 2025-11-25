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
import com.phsecurities.susu.service.VaultContributionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.phsecurities.susu.model.VaultContribution;

@RestController 
@Tag(name = "PledgePay - Vault Contributions", description = "Endpoints for anything PledgePay Request - vault contributions related in PledgePay")
@RequestMapping("/vault-contributions")
class VaultContributionController {
    @Autowired 
    private VaultContributionService service;

    @PostMapping("/create")
    @Operation(summary = "Endpoint to create a new vault contribution")
    public VaultContribution create(@RequestBody VaultContribution vc) { 
        return service.save(vc); 
    }
    @GetMapping("/list")
    @Operation(summary = "Endpoint to list all vault contributions")
    public List<VaultContribution> list() { 
        return service.getAll(); 
    }

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint to get a vault contribution by ID")
    public ResponseEntity<VaultContribution> get(@PathVariable UUID id) {
        return service.getAll().stream().filter(c -> c.getVaultContributionId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Endpoint to update a vault contribution by ID")
    public ResponseEntity<VaultContribution> update(@PathVariable UUID id, @RequestBody VaultContribution vc) {
        vc.setVaultContributionId(id); return ResponseEntity.ok(service.save(vc));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint to delete a vault contribution by ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id); return ResponseEntity.noContent().build();
    }
}
