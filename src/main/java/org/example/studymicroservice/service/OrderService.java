package org.example.studymicroservice.service;

import lombok.RequiredArgsConstructor;
import org.example.studymicroservice.client.ProductClient;
import org.example.studymicroservice.client.UserClient;
import org.example.studymicroservice.entity.Order;
import org.example.studymicroservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repo;
    private final ProductClient productClient;
    private final UserClient userClient;

    public Order createOrder(Integer userId, Integer productId, Integer quantity) {

        String user = userClient.getUser(userId);

        String product = productClient.getProduct(productId);

        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setStatus("CREATED");

        repo.save(order);

        productClient.decrease(productId, quantity);

        return order;
    }
}
