package org.example.integration.impl;

import org.example.integration.CatalogIntegrationService;
import org.example.integration.data.ProductData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

public class CatalogIntegrationServiceImpl implements CatalogIntegrationService {

    private WebClient webClient;

    @Value("${backing.service.catalog.url}")
    private String catalogServiceUrl;

    public CatalogIntegrationServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<ProductData> getProductData(String productUuid) {
        return webClient
                .get()
                .uri(catalogServiceUrl + "/" + productUuid).retrieve()
                .bodyToMono(ProductData.class)
                .timeout(Duration.ofSeconds(3))
                .retryWhen(Retry.backoff(3, Duration.ofMillis(100)));
    }
}
