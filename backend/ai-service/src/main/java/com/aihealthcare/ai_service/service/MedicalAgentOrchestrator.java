package com.aihealthcare.ai_service.service;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MedicalAgentOrchestrator {

    private final AgentService agentService;
    private final AIService aiService;
    private final OrchestratorAgent orchestratorAgent;

    public MedicalAgentOrchestrator(
            AgentService agentService,
            AIService aiService,
            RestTemplate restTemplate,
            @Value("${langchain4j.ollama.base-url:http://localhost:11434}") String ollamaBaseUrl,
            @Value("${langchain4j.ollama.chat-model-name:llama3.2}") String chatModelName) {

        this.agentService = agentService;
        this.aiService = aiService;

        ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl(ollamaBaseUrl)
                .modelName(chatModelName)
                .temperature(0.2)
                .build();

        this.orchestratorAgent = AiServices.builder(OrchestratorAgent.class)
                .chatLanguageModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(20))
                .tools(new OrchestratorTools(restTemplate, aiService))
                .build();
    }

    public String handle(String query) {
        return orchestratorAgent.orchestrate(query);
    }

    interface OrchestratorAgent {
        String orchestrate(String query);
    }

    static class OrchestratorTools {
        private final RestTemplate restTemplate;
        private final AIService aiService;

        OrchestratorTools(RestTemplate restTemplate, AIService aiService) {
            this.restTemplate = restTemplate;
            this.aiService = aiService;
        }

        @Tool("Analyze patient symptoms and provide medical guidance")
        public String analyzeSymptoms(String symptoms) {
            return aiService.symptomChecker(symptoms);
        }

        @Tool("Search medical knowledge base for specific condition")
        public String searchMedicalKnowledge(String query) {
            return aiService.ragChat(query);
        }

        @Tool("Get available doctors by specialization")
        public String getDoctorsBySpecialization(String specialization) {
            try {
                String url = "http://doctor-service:8083/api/doctors";
                if (specialization != null && !specialization.isEmpty()) {
                    url += "?specialization=" + specialization;
                }
                return restTemplate.getForObject(url, String.class);
            } catch (Exception e) {
                return "Error fetching doctors: " + e.getMessage();
            }
        }

        @Tool("Get available appointments for a doctor")
        public String getAppointmentsForDoctor(String doctorId) {
            try {
                String url = "http://appointment-service:8084/api/appointments";
                if (doctorId != null && !doctorId.isEmpty()) {
                    url += "?doctorId=" + doctorId;
                }
                return restTemplate.getForObject(url, String.class);
            } catch (Exception e) {
                return "Error fetching appointments: " + e.getMessage();
            }
        }

        @Tool("Get patient medical history")
        public String getPatientMedicalHistory(String patientId) {
            try {
                return restTemplate.getForObject(
                        "http://medical-record-service:8087/api/medical-records/patient/" + patientId,
                        String.class);
            } catch (Exception e) {
                return "Error fetching medical history: " + e.getMessage();
            }
        }

        @Tool("Create appointment booking")
        public String bookAppointment(String patientId, String doctorId, String dateTime) {
            try {
                String url = "http://appointment-service:8084/api/appointments/book";
                String body = String.format(
                        "{\"patientId\":\"%s\",\"doctorId\":\"%s\",\"appointmentDateTime\":\"%s\"}",
                        patientId, doctorId, dateTime);
                return restTemplate.postForObject(url, body, String.class);
            } catch (Exception e) {
                return "Error booking appointment: " + e.getMessage();
            }
        }

        @Tool("Summarize medical report")
        public String summarizeReport(String report) {
            return aiService.summarizeReport(report);
        }

        @Tool("Analyze prescription")
        public String analyzePrescription(String prescription) {
            return aiService.analyzePrescription(prescription);
        }

        @Tool("Analyze lab report")
        public String analyzeLabReport(String report) {
            return aiService.analyzeLabReport(report);
        }
    }
}