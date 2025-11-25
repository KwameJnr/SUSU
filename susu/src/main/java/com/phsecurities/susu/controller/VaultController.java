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
import com.phsecurities.susu.service.VaultService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.phsecurities.susu.model.PersonalSavingsVault;

@RestController 
@Tag(name = "PledgePay - Personal Savings Vault", description = "Endpoints for anything PledgePay Request - personal savings vault contributions related in PledgePay")
@RequestMapping("/vaults")
class VaultController {
    @Autowired private VaultService service;

    @PostMapping("/create")
    @Operation(summary = "Endpoint to create a new personal savings vault")
    public PersonalSavingsVault create(@RequestBody PersonalSavingsVault psv) { 
        return service.save(psv); 
    }
    @GetMapping("/list")
    @Operation(summary = "Endpoint to list all personal savings vaults")
    public List<PersonalSavingsVault> list() { 
        return service.getAll(); 
    }

     @GetMapping("/{id}")
    @Operation(summary = "Endpoint to get a personal savings vault by ID")
    public ResponseEntity<PersonalSavingsVault> get(@PathVariable UUID id) {
        return service.getAll().stream().filter(c -> c.getVaultId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Endpoint to update a personal savings vault by ID")
    public ResponseEntity<PersonalSavingsVault> update(@PathVariable UUID id, @RequestBody PersonalSavingsVault psv) {
        psv.setVaultId(id); return ResponseEntity.ok(service.save(psv));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint to delete a personal savings vault by ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id); return ResponseEntity.noContent().build();
    }
}
