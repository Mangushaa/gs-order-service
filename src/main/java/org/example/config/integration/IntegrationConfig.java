package org.example.config.integration;

import org.example.integration.impl.CatalogIntegrationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class IntegrationConfig {

    @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.build();
    }

    @Bean
    public CatalogIntegrationServiceImpl catalogIntegrationService(WebClient webClient) {
        return new CatalogIntegrationServiceImpl(webClient);
    }

}
