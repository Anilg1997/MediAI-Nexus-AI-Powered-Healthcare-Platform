package com.aihealthcare.ai_service.service;

import com.aihealthcare.ai_service.dto.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class AiAnalysisService {

    public SymptomResponseDto
    analyzeSymptoms(
            SymptomRequestDto request) {

        String symptoms =
                request.getSymptoms()
                        .toLowerCase();

        List<String>
                diseases =
                new ArrayList<>();

        String doctor =
                "General Physician";

        if (symptoms.contains("fever")
                &&
                symptoms.contains("cough")) {

            diseases.add("Flu");

            diseases.add(
                    "Viral Fever");
        }

        if (symptoms.contains("headache")) {

            diseases.add(
                    "Migraine");
        }

        if (symptoms.contains("chest pain")) {

            diseases.add(
                    "Heart Disease");

            doctor =
                    "Cardiologist";
        }

        if (symptoms.contains("skin")) {

            diseases.add(
                    "Skin Allergy");

            doctor =
                    "Dermatologist";
        }

        if (diseases.isEmpty()) {

            diseases.add(
                    "No major disease detected");
        }

        return new SymptomResponseDto(

                diseases,

                doctor);
    }
}