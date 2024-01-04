package org.example.api;


import com.github.dockerjava.api.exception.BadRequestException;
import org.example.api.converter.OrderRequestMapper;
import org.example.api.requets.OrderRequest;
import org.example.model.Order;
import org.example.service.ReactiveOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    private static final String ERROR_ORDER_SUBMIT_MSG = "Erorr sumbit order. Errors: {}";

    @Autowired
    private ReactiveOrderService reactiveOrderService;

    @GetMapping
    public Flux<Order> getAllOrders() {
        return reactiveOrderService.getAllOrders();
    }

    @GetMapping("/{uuid}")
    public Mono<Order> getOrderByUuid(@PathVariable String uuid) {
        return reactiveOrderService.getOrderByUuid(uuid);
    }


    @PostMapping("/submit")
    public Mono<Order> submitOrder(@RequestBody OrderRequest orderRequest) {
        return reactiveOrderService.submitOrder(orderRequest);
    }



}
