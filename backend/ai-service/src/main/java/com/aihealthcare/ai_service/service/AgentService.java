package com.aihealthcare.ai_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AgentService {

    private final AIService aiService;

    private final RestTemplate
            restTemplate;
    public AgentService(
            AIService aiService,
            RestTemplate restTemplate) {

        this.aiService =
                aiService;
        this.restTemplate=restTemplate;

    }

    public String process(
            String query) {

        String lowerQuery =
                query.toLowerCase();

        if (lowerQuery.contains(
                "appointment")) {

            return restTemplate
                    .getForObject(
                            "http://localhost:8084/api/appointments",
                            String.class);
        }

        if (lowerQuery.contains(
                "doctor")) {

            return restTemplate
        .getForObject(
                    "http://localhost:8083/api/doctors",
                    String.class);
        }

        if (lowerQuery.contains(
                "patient")) {

            return restTemplate
                    .getForObject(
                            "http://localhost:8082/api/patients",
                            String.class);
        }

        return aiService.chat(
                query);
    }
}