package org.example.studymicroservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(OrderController.PATH)
public class OrderController {

    public static final String PATH = "/order";

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUser(@PathVariable int id) {

        WebClient webClient = WebClient.create("/http://localhost:8080/");

        Mono<String> result = webClient.get()
                .uri("/user")
                .retrieve()
                .bodyToMono(String.class);

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("user", result);

        return ResponseEntity.ok(map);
    }
}
