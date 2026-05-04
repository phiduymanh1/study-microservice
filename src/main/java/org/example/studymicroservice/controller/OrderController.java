package org.example.studymicroservice;

import lombok.RequiredArgsConstructor;
import org.example.studymicroservice.client.UserClient;
import org.example.studymicroservice.entity.Order;
import org.example.studymicroservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(OrderController.PATH)
@RequiredArgsConstructor
public class OrderController {

    public static final String PATH = "/order";

    private final OrderService service;
    private final UserClient userClient;

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUser(@PathVariable int id) {

        String user = userClient.getUser(id);

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("user", user);

        return ResponseEntity.ok(map);
    }

    @PostMapping
    public Order create(@RequestBody Map<String, Integer> req) {
        return service.createOrder(
                req.get("userId"),
                req.get("productId"),
                req.get("quantity")
        );
    }
}
