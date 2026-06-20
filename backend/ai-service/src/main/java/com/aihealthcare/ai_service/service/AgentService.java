package com.aihealthcare.ai_service.service;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolSpecification;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AgentService {

    private final AIService aiService;
    private final RestTemplate restTemplate;
    private final HealthcareAgent healthcareAgent;

    public AgentService(
            AIService aiService,
            RestTemplate restTemplate,
            @Value("${langchain4j.ollama.base-url:http://localhost:11434}") String ollamaBaseUrl,
            @Value("${langchain4j.ollama.chat-model-name:llama3.2}") String chatModelName) {

        this.aiService = aiService;
        this.restTemplate = restTemplate;

        ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl(ollamaBaseUrl)
                .modelName(chatModelName)
                .temperature(0.3)
                .build();

        this.healthcareAgent = AiServices.builder(HealthcareAgent.class)
                .chatLanguageModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .tools(new HealthcareTools(restTemplate))
                .build();
    }

    public String process(String query) {
        return healthcareAgent.process(query);
    }

    public interface HealthcareAgent {
        String process(String query);
    }

    static class HealthcareTools {
        private final RestTemplate restTemplate;

        HealthcareTools(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        @Tool("Get list of all doctors")
        public String getDoctors() {
            try {
                return restTemplate.getForObject("http://doctor-service:8083/api/doctors", String.class);
            } catch (Exception e) {
                return "Error fetching doctors: " + e.getMessage();
            }
        }

        @Tool("Get list of all appointments")
        public String getAppointments() {
            try {
                return restTemplate.getForObject("http://appointment-service:8084/api/appointments", String.class);
            } catch (Exception e) {
                return "Error fetching appointments: " + e.getMessage();
            }
        }

        @Tool("Get list of all patients")
        public String getPatients() {
            try {
                return restTemplate.getForObject("http://patient-service:8082/api/patients", String.class);
            } catch (Exception e) {
                return "Error fetching patients: " + e.getMessage();
            }
        }

        @Tool("Search medical knowledge base using RAG")
        public String searchMedicalKnowledge(String query) {
            // This will be handled by the AI service
            return "Medical knowledge search for: " + query;
        }
    }
}