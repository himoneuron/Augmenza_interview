package com.mcqplatform.mcq_backend.dto;

import java.util.Map;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class AssessmentSubmissionRequest {
    @NotBlank private String fullName;
    @Email private String email;
    @NotBlank private String contactNumber;
    
    // Security: Only accept answers, not the score!
    private Map<Long, String> answers; // QuestionID -> SelectedOption ("A", "B")
    
    // Proctoring data is fine from client
    private int tabSwitchCount;
}