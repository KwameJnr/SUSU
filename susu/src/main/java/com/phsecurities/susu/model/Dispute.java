package com.phsecurities.susu.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Disputes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dispute {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID disputeId;

    @ManyToOne
    @JoinColumn(name = "raised_by")
    private User raisedBy;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @Lob
    private String description;
    private String status;
    private LocalDateTime createdAt = LocalDateTime.now();
}
