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
import com.phsecurities.susu.service.NotificationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.phsecurities.susu.model.Notification;

@RestController 
@Tag(name = "PledgePay - Notifications", description = "Endpoints for anything PledgePay Request - notifications related in PledgePay")
@RequestMapping("/notifications")
class NotificationController {
    @Autowired 
    private NotificationService service;

    @PostMapping("/create")
    @Operation(summary = "Endpoint to create a new notification")
    public Notification create(@RequestBody Notification n) { 
        return service.save(n); 
    }
    @GetMapping("/list")
    @Operation(summary = "Endpoint to list all notifications")
    public List<Notification> list() { 
        return service.getAll(); 
    }

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint to get a notification by ID")
    public ResponseEntity<Notification> get(@PathVariable UUID id) {
        return service.getAll().stream().filter(c -> c.getNotificationId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Endpoint to update a notification by ID")
    public ResponseEntity<Notification> update(@PathVariable UUID id, @RequestBody Notification n) {
        n.setNotificationId(id); return ResponseEntity.ok(service.save(n));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint to delete a notification by ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id); return ResponseEntity.noContent().build();
    }
}
