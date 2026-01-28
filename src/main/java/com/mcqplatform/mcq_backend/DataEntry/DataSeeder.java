package com.mcqplatform.mcq_backend.DataEntry;

import com.mcqplatform.mcq_backend.entity.Question;
import com.mcqplatform.mcq_backend.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final QuestionRepository questionRepo;

    @Override
    public void run(String... args) throws Exception {
        if (questionRepo.count() > 0) return; // Don't seed if data exists

        // --- JAVA QUESTIONS ---
        Question q1 = Question.builder()
                .content("What is the size of int in Java?")
                .category("Java")
                .difficulty("Basic")
                .options(Map.of("A", "8 bit", "B", "32 bit", "C", "64 bit", "D", "16 bit"))
                .correctOptionKey("B") // 32 bit
                .build();

        Question q2 = Question.builder()
                .content("Which keyword is used to stop inheritance in Java?")
                .category("Java")
                .difficulty("Intermediate")
                .options(Map.of("A", "static", "B", "final", "C", "super", "D", "abstract"))
                .correctOptionKey("B") // final
                .build();

        // --- SPRING BOOT QUESTIONS ---
        Question q3 = Question.builder()
                .content("Which annotation is used to define a REST Controller?")
                .category("Spring Boot")
                .difficulty("Basic")
                .options(Map.of("A", "@Controller", "B", "@RestController", "C", "@Service", "D", "@Component"))
                .correctOptionKey("B") // @RestController
                .build();
        
        // Add more questions here...
        
        questionRepo.saveAll(List.of(q1, q2, q3));
        System.out.println("✅ Database Seeded with Sample Questions!");
    }
}