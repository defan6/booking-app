package my.ddos.orderservice.service;

import my.ddos.orderservice.model.dto.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
