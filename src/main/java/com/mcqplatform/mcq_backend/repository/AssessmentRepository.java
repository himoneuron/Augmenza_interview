package com.mcqplatform.mcq_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcqplatform.mcq_backend.entity.CandidateAssessment;

@Repository
public interface AssessmentRepository extends JpaRepository<CandidateAssessment, Long> {
    // Custom query to check if email already took test
    boolean existsByEmail(String email);
}