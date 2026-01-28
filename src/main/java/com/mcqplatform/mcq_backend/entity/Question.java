package com.mcqplatform.mcq_backend.entity;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "questions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content; // The actual question text

    @Column(nullable = false)
    private String category; // e.g., "JAVA", "REACT", "DEVOPS"

    @Column(nullable = false)
    private String difficulty; // "JUNIOR", "MID", "SENIOR"

    // Stores options like: {"A": "Singleton", "B": "Prototype", "C": "Request"}
    // In Postgres, this is best stored as JSONB. For simplicity/H2, we use ElementCollection.
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_id"))
    @MapKeyColumn(name = "option_key") // "A", "B", "C", "D"
    @Column(name = "option_text")
    private Map<String, String> options; 

    // 🛑 CRITICAL SECURITY: This field stays in DB. Never send to Client DTO.
    @Column(nullable = false)
    private String correctOptionKey; // e.g., "B"
}