//package org.example.api.converter.impl;
//
//import org.example.api.converter.OrderRequestMapper;
//import org.example.api.requets.OrderRequest;
//import org.example.model.Order;
//import org.example.model.enums.OrderStatus;
//
//public class OrderRequestMapperImpl implements OrderRequestMapper {
//    @Override
//    public Order orderRequestToOrder(OrderRequest orderRequest) {
//        return Order.of(orderRequest.total(), OrderStatus.CONFIRMED);
//    }
//}
