package com.aihealthcare.ai_service.service;

import org.springframework.stereotype.Service;

@Service
public class MedicalAgentOrchestrator {

    private final AgentService
            agentService;

    public MedicalAgentOrchestrator(
            AgentService agentService) {

        this.agentService =
                agentService;
    }

    public String handle(
            String query) {

        if(query.toLowerCase()
                .contains("fever")) {

            String doctors =
                    agentService.process(
                            "show doctors");

            String appointments =
                    agentService.process(
                            "show appointments");

            return """
                    Possible fever case

                    Available Doctors:

                    %s

                    Available Appointments:

                    %s
                    """
                    .formatted(
                            doctors,
                            appointments);
        }

        return agentService
                .process(query);
    }
}