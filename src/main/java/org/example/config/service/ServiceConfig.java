package org.example.config.service;


import org.example.integration.CatalogIntegrationService;
import org.example.repository.OrdersRepository;
import org.example.service.ReactiveOrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public ReactiveOrderServiceImpl reactiveOrderService(OrdersRepository ordersRepository, CatalogIntegrationService catalogIntegrationService) {
        return new ReactiveOrderServiceImpl(ordersRepository, catalogIntegrationService);
    }

}

