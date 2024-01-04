package org.example.service;

import org.example.api.requets.OrderEntryRequest;
import org.example.api.requets.OrderRequest;
import org.example.integration.CatalogIntegrationService;
import org.example.integration.data.ProductData;
import org.example.model.Order;
import org.example.model.enums.OrderStatus;
import org.example.repository.OrdersRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveOrderServiceImpl implements ReactiveOrderService {

    private OrdersRepository ordersRepository;
    private CatalogIntegrationService catalogIntegrationService;

    public ReactiveOrderServiceImpl(OrdersRepository ordersRepository, CatalogIntegrationService catalogIntegrationService) {
        this.ordersRepository = ordersRepository;
        this.catalogIntegrationService = catalogIntegrationService;
    }

    @Override
    public Flux<Order> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public Mono<Order> getOrderByUuid(String uuid) {
        return ordersRepository.findByUuid(uuid);
    }

    @Override
    public Mono<Order> submitOrder(OrderRequest order) {
        return Flux.fromIterable(order.orderRequest())
                .parallel()
                .flatMap(orderEntryRequest -> {
                    System.out.println("Executing call to service in thread: " + Thread.currentThread());
                    return catalogIntegrationService.getProductData(orderEntryRequest.productUuid());
                })
                .sequential()
                .map(ProductData::total)
                .reduce(0, Integer::sum)
                .map(orderTotal -> Order.of(orderTotal, OrderStatus.CONFIRMED))
                .flatMap(ordersRepository::save);
    }


}
