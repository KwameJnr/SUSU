package com.phsecurities.susu.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

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
@Table(name = "Payouts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payout {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID payoutId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private User recipient;

    private Integer cycleNumber;
    private BigDecimal amount;
    private LocalDate payoutDate;
    private boolean approvedByAdmin = false;
}
