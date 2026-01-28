package com.mcqplatform.mcq_backend.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidate_assessments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- Personal Details ---
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contactNumber;

    // --- Professional Details ---
    private int yearsOfExperience;
    
    private String roleApplied; // e.g., "Backend Developer"
    
    // Using ElementCollection for simple list storage in H2/Postgres
    @ElementCollection 
    private List<String> skillSet; 

    // --- Assessment Results ---
    // ⚠️ CHANGED: Renamed from 'percentage' to 'score' to match your Service
    private double score; 
    
    private int totalQuestions;
    private int correctAnswers;
    private int totalMarks; 

    // --- Proctoring Flags ---
    // ⚠️ CHANGED: Renamed from 'tabSwitched' to 'isSuspicious' to match your Service
    private boolean isSuspicious; 
    
    private int tabSwitchCount;
    private boolean cameraEnabled;

    @CreationTimestamp
    private LocalDateTime submissionTime;
}