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
import com.phsecurities.susu.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.phsecurities.susu.model.User;

@RestController 
@Tag(name = "PledgePay - Users", description = "Endpoints for anything PledgePay Request - user related in PledgePay")
@RequestMapping("/users")
class UserController {
    @Autowired 
    private UserService service;

    @PostMapping("/create") 
    @Operation(summary = "Endpoint to create a new user")
    public User create(@RequestBody User u) { 
        return service.save(u); 
    }
    @GetMapping("/list")
    @Operation(summary = "Endpoint to list all users") 
    public List<User> list() { 
        return service.getAll(); 
    }

    @GetMapping("/{id}") 
    @Operation(summary = "Endpoint to get a user by ID")
    public ResponseEntity<User> get(@PathVariable UUID id) {
        return service.getAll().stream().filter(u -> u.getUserId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}") 
    @Operation(summary = "Endpoint to update a user by ID")
    public ResponseEntity<User> update(@PathVariable UUID id, @RequestBody User u) {
        u.setUserId(id); return ResponseEntity.ok(service.save(u));
    }

    @DeleteMapping("/{id}") 
    @Operation(summary = "Endpoint to delete a user by ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id); return ResponseEntity.noContent().build();
    }
}
