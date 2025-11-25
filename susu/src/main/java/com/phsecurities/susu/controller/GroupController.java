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
import com.phsecurities.susu.service.GroupService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.phsecurities.susu.model.Group;

@RestController 
@Tag(name = "PledgePay - Groups", description = "Endpoints for anything PledgePay Request - groups related in PledgePay")
@RequestMapping("/groups")
class GroupController {
    @Autowired 
    private GroupService service;

    @PostMapping("/create")
    @Operation(summary = "Endpoint to create a new group")
    public Group create(@RequestBody Group g) { 
        return service.save(g); 
    }
    @GetMapping("/list")
    @Operation(summary = "Endpoint to list all groups") 
    public List<Group> list() { 
        return service.getAll(); 
    }

    @GetMapping("/{id}") 
    @Operation(summary = "Endpoint to get a group by ID")
    public ResponseEntity<Group> get(@PathVariable UUID id) {
        return service.getAll().stream().filter(c -> c.getGroupId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}") 
    @Operation(summary = "Endpoint to update a group by ID")
    public ResponseEntity<Group> update(@PathVariable UUID id, @RequestBody Group g) {
        g.setGroupId(id); return ResponseEntity.ok(service.save(g));
    }

    @DeleteMapping("/{id}") 
    @Operation(summary = "Endpoint to delete a group by ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id); return ResponseEntity.noContent().build();
    }
}
