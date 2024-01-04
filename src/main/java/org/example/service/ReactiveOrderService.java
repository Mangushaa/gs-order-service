package org.example.service;

import org.example.api.requets.OrderRequest;
import org.example.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveOrderService {

    Flux<Order> getAllOrders();

    Mono<Order> getOrderByUuid(String uuid);

    Mono<Order> submitOrder(OrderRequest orderRequest);
}
