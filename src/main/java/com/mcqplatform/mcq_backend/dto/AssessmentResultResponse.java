package com.mcqplatform.mcq_backend.dto;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class AssessmentResultResponse {
    private String candidateId;
    private String status; // "PASSED" / "FAILED"
    private double scorePercentage;
}