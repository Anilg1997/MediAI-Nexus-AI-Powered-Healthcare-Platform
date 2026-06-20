package com.aihealthcare.ai_service.service;

import com.aihealthcare.ai_service.entity.DocumentData;
import com.aihealthcare.ai_service.repository.DocumentRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AIService {

    private final ChatClient chatClient;
    private final VectorStore vectorStore;
    private final DocumentRepository documentRepository;
    private final RetrievalService retrievalService;

    public AIService(
            ChatClient.Builder builder,
            DocumentRepository documentRepository,
            VectorStore vectorStore,
            RetrievalService retrievalService) {

        this.chatClient = builder.build();
        this.documentRepository = documentRepository;
        this.vectorStore = vectorStore;
        this.retrievalService = retrievalService;
    }

    public String chat(String question) {
        return chatClient.prompt()
                .user(question)
                .call()
                .content();
    }

    public String symptomChecker(String symptoms) {
        String prompt = """
                You are a healthcare assistant.
                Provide general health information only.
                Do not diagnose diseases.
                Symptoms: %s
                """.formatted(symptoms);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    public String ragChat(String question) {
        List<Document> docs = retrievalService.retrieveTopDocuments(question);

        String context = docs.stream()
                .map(Document::getText)
                .collect(Collectors.joining("\n"));

        String prompt = """
                You are a healthcare assistant.

                Answer ONLY using the medical records below.

                Records:
                %s

                Question:
                %s
                """.formatted(context, question);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    public String summarizeReport(String report) {
        String prompt = """
                You are a healthcare assistant.

                Summarize the medical report below.

                Explain:
                1. Main findings
                2. Important observations
                3. Possible concerns
                4. Simple patient-friendly summary

                Report:
                %s
                """.formatted(report);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    public String analyzePrescription(String prescription) {
        String prompt = """
                You are a healthcare assistant.

                Analyze this prescription.

                Explain:
                1. Medicines
                2. Purpose of each medicine
                3. Important precautions
                4. Simple patient-friendly summary

                Prescription:
                %s
                """.formatted(prescription);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    public String analyzeLabReport(String report) {
        String prompt = """
                You are a healthcare assistant.

                Analyze this lab report.

                Explain:
                1. Abnormal values
                2. Possible meaning
                3. Health recommendations
                4. Patient-friendly summary

                Lab Report:
                %s
                """.formatted(report);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    public String medicalAssistant(String question) {
        List<Document> docs = retrievalService.retrieveTopDocuments(question);

        String context = docs.stream()
                .map(Document::getText)
                .collect(Collectors.joining("\n"));

        String prompt = """
                You are a healthcare assistant.

                Use ONLY the medical records below.

                Records:
                %s

                Question:
                %s
                """.formatted(context, question);

        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    public void addDocument(String content, String fileName) {
        DocumentData docData = new DocumentData();
        docData.setContent(content);
        docData.setFileName(fileName);
        documentRepository.save(docData);

        Document document = new Document(content);
        vectorStore.add(List.of(document));
    }

    public void addDocuments(List<String> contents, List<String> fileNames) {
        for (int i = 0; i < contents.size(); i++) {
            addDocument(contents.get(i), fileNames.get(i));
        }
    }
}