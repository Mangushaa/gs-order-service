package org.example.integration;

import org.example.integration.data.ProductData;
import reactor.core.publisher.Mono;

public interface CatalogIntegrationService {

    Mono<ProductData> getProductData(String productUuid);
}
