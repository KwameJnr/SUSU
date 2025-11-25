package com.phsecurities.susu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import com.phsecurities.susu.model.GroupMember;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, UUID> {}
