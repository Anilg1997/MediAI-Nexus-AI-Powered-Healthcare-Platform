package com.aihealthcare.ai_service.controller;

import com.aihealthcare.ai_service.service.AgentService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agent")
@CrossOrigin(origins = "*")
public class AgentController {

    private final AgentService
            agentService;

    public AgentController(
            AgentService agentService) {

        this.agentService =
                agentService;
    }

    @GetMapping("/ask")
    public String askAgent(
            @RequestParam String query) {

        return agentService
                .process(query);
    }
}