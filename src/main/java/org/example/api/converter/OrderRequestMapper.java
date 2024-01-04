package org.example.api.converter;

import org.example.api.requets.OrderRequest;
import org.example.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

public interface OrderRequestMapper {

    Order orderRequestToOrder(OrderRequest orderRequest);
}
