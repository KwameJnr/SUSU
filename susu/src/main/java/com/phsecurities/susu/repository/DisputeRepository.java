package com.phsecurities.susu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phsecurities.susu.model.Dispute;

@Repository
public interface DisputeRepository extends JpaRepository<Dispute, UUID> {}
