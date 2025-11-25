package com.phsecurities.susu.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phsecurities.susu.model.PersonalSavingsVault;

@Repository
public interface PersonalSavingsVaultRepository extends JpaRepository<PersonalSavingsVault, UUID> {}
