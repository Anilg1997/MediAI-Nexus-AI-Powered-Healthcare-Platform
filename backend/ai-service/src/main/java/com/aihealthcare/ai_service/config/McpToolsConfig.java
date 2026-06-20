package com.aihealthcare.ai_service.config;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.mcp.server.McpServer;
import dev.langchain4j.mcp.server.McpToolProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class McpToolsConfig {

    @Bean
    public McpToolProvider healthcareMcpTools(RestTemplate restTemplate) {
        return new HealthcareMcpTools(restTemplate);
    }

    public static class HealthcareMcpTools implements McpToolProvider {

        private final RestTemplate restTemplate;

        public HealthcareMcpTools(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        @Tool(name = "get_doctors", description = "Get list of all doctors in the system")
        public String getDoctors() {
            try {
                return restTemplate.getForObject("http://doctor-service:8083/api/doctors", String.class);
            } catch (Exception e) {
                return "Error fetching doctors: " + e.getMessage();
            }
        }

        @Tool(name = "get_patients", description = "Get list of all patients in the system")
        public String getPatients() {
            try {
                return restTemplate.getForObject("http://patient-service:8082/api/patients", String.class);
            } catch (Exception e) {
                return "Error fetching patients: " + e.getMessage();
            }
        }

        @Tool(name = "get_appointments", description = "Get list of all appointments")
        public String getAppointments() {
            try {
                return restTemplate.getForObject("http://appointment-service:8084/api/appointments", String.class);
            } catch (Exception e) {
                return "Error fetching appointments: " + e.getMessage();
            }
        }

        @Tool(name = "search_medical_knowledge", description = "Search medical knowledge base using RAG")
        public String searchMedicalKnowledge(String query) {
            return "Medical knowledge search for: " + query;
        }

        @Tool(name = "analyze_symptoms", description = "Analyze patient symptoms and provide medical guidance")
        public String analyzeSymptoms(String symptoms) {
            return "Symptom analysis for: " + symptoms;
        }

        @Tool(name = "get_patient_history", description = "Get patient medical history")
        public String getPatientHistory(String patientId) {
            try {
                return restTemplate.getForObject(
                        "http://medical-record-service:8087/api/medical-records/patient/" + patientId,
                        String.class);
            } catch (Exception e) {
                return "Error fetching medical history: " + e.getMessage();
            }
        }
    }
}