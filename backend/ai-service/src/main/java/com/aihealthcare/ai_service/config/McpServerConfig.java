package com.aihealthcare.ai_service.config;

import dev.langchain4j.mcp.McpServer;
import dev.langchain4j.mcp.McpTransport;
import dev.langchain4j.mcp.server.McpServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpServerConfig {

    @Value("${langchain4j.mcp.server.enabled:true}")
    private boolean mcpEnabled;

    @Value("${langchain4j.mcp.server.port:8093}")
    private int mcpPort;

    @Value("${langchain4j.mcp.server.transport:STDIO}")
    private String mcpTransport;

    @Bean
    public McpServer mcpServer() {
        if (!mcpEnabled) {
            return null;
        }

        McpTransport transport = McpTransport.valueOf(mcpTransport);

        return McpServerBuilder.builder()
                .name("ai-healthcare-mcp-server")
                .version("1.0.0")
                .transport(transport)
                .port(mcpPort)
                .build();
    }
}