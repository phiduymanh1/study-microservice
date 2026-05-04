package org.example.studymicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "product-service", url = "http://localhost:8082")
public interface ProductClient {

    @GetMapping("/products/{id}")
    String getProduct(@PathVariable Integer id);

    @PutMapping("/products/{id}/decrease")
    void decrease(@PathVariable Integer id,
                  @RequestParam Integer quantity);
}
