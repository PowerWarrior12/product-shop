package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.order.CreateOrderDto;
import org.example.dto.order.FullOrderDto;
import org.example.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/add")
    public ResponseEntity<FullOrderDto> addOrder(@RequestBody CreateOrderDto createOrderDto, Principal principal) {
        return ResponseEntity.ok(orderService.createOrder(createOrderDto, principal));
    }

    @GetMapping("/my")
    public ResponseEntity<Collection<FullOrderDto>> getAllOrdersByUser(Principal principal) {
        return ResponseEntity.ok(orderService.loadUserOrders(principal));
    }
}
