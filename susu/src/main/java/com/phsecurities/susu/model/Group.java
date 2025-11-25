package com.phsecurities.susu.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID groupId;

    private String groupName;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private Integer numMembers;
    private BigDecimal contributionAmount;
    private String frequency;
    private String rotationOrder;
    private LocalDate startDate;

    @Column(unique = true)
    private String inviteCode;

    private boolean isActive = true;
}

