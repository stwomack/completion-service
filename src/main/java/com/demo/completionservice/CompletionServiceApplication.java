package com.demo.completionservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class CompletionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompletionServiceApplication.class, args);
    }
}

@RestController
class OrderCompletionController {

    private final OrderRepository orderRepository;

    public OrderCompletionController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/completions")
    public String completeOrder(@RequestBody Order order) {
        orderRepository.save(order);
        return "Order completed";
    }
}

@Repository
interface OrderRepository extends JpaRepository<Order, Long> {
}