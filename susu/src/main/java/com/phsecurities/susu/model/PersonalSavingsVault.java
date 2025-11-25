package com.phsecurities.susu.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
@Table(name = "PersonalSavingsVault")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalSavingsVault {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID vaultId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private BigDecimal goalAmount;
    private String purpose;
    private String frequency;
    private int lockInPeriodMonths;
    private LocalDate startDate;
    private LocalDate unlockDate;
    private BigDecimal penaltyPercent;
    private boolean allowEarlyWithdrawal;
    private LocalDateTime createdAt = LocalDateTime.now();
}
