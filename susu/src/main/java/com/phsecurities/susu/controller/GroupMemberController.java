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
import com.phsecurities.susu.service.GroupMemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.phsecurities.susu.model.GroupMember;

@RestController 
@Tag(name = "PledgePay - Group Members", description = "Endpoints for anything PledgePay Request - group members related in PledgePay")
@RequestMapping("/group-members")
class GroupMemberController {
    @Autowired 
    private GroupMemberService service;

    @PostMapping("/create")
    @Operation(summary = "Endpoint to create a new group member")
    public GroupMember create(@RequestBody GroupMember m) { 
        return service.save(m); 
    }
    @GetMapping("/list")
    @Operation(summary = "Endpoint to list all group members")
    public List<GroupMember> list() { 
        return service.getAll(); 
    }

    @GetMapping("/{id}")
    @Operation(summary = "Endpoint to get a group member by ID")
    public ResponseEntity<GroupMember> get(@PathVariable UUID id) {
        return service.getAll().stream().filter(c -> c.getGroupMemberId().equals(id)).findFirst()
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Endpoint to update a group member by ID")
    public ResponseEntity<GroupMember> update(@PathVariable UUID id, @RequestBody GroupMember m) {
        m.setGroupMemberId(id); return ResponseEntity.ok(service.save(m));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint to delete a group member by ID")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.deleteById(id); return ResponseEntity.noContent().build();
    }
}
