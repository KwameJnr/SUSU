package com.phsecurities.susu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phsecurities.susu.model.Contribution;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution, UUID> {}
