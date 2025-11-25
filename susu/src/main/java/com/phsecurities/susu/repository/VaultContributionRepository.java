package com.phsecurities.susu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phsecurities.susu.model.VaultContribution;

@Repository
public interface VaultContributionRepository extends JpaRepository<VaultContribution, UUID> {}