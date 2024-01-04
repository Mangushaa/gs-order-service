package org.example.repository;

import org.example.model.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface OrdersRepository extends ReactiveCrudRepository<Order, Long> {

    Mono<Order> findByUuid(String uuid);
}
