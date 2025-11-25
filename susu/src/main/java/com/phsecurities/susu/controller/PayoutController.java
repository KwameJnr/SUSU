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
import com.phsecurities.susu.service.PayoutService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.phsecurities.susu.model.Payout;

@RestController 
@Tag(name = "PledgePay - Payouts", description = "Endpoints for anything PledgePay Request - payouts related in PledgePay")
@RequestMapping("/payouts")
class PayoutController {
    @Autowired 
    private PayoutService service;

    @PostMapping("/create")
    @Operation(summary = "Endpoint to create a new payout")
    public Payout create(@RequestBody Payout p) { 
        return service.save(p); 
    }

    @GetMapping("/list")
    @Operation(summary = "Endpoint to list all payouts")
     public List<Payout> list() { 
        return service.getAll(); 
    }

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint to get a payout by ID")
    public ResponseEntity<Payout> get(@PathVariable UUID id) {
        return service.getAll().stream().filter(c -> c.getPayoutId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Endpoint to update a payout by ID")
    public ResponseEntity<Payout> update(@PathVariable UUID id, @RequestBody Payout p) {
        p.setPayoutId(id); return ResponseEntity.ok(service.save(p));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint to delete a payout by ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id); return ResponseEntity.noContent().build();
    }
}
