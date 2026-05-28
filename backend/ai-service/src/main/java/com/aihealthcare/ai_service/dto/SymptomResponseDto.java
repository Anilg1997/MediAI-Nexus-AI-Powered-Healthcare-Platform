package com.aihealthcare.ai_service.dto;

import java.util.List;

public class SymptomResponseDto {

    private List<String>
            possibleDiseases;

    private String
            recommendedDoctor;

    public SymptomResponseDto(
            List<String> possibleDiseases,

            String recommendedDoctor) {

        this.possibleDiseases =
                possibleDiseases;

        this.recommendedDoctor =
                recommendedDoctor;
    }

    public List<String>
    getPossibleDiseases() {

        return possibleDiseases;
    }

    public String
    getRecommendedDoctor() {

        return recommendedDoctor;
    }
}