package org.example.services;

import org.example.dto.order.CreateOrderDto;
import org.example.dto.order.FullOrderDto;

import java.security.Principal;
import java.util.Collection;

public interface OrderService {
    public FullOrderDto createOrder(CreateOrderDto createOrderDto, Principal principal);
    public Collection<FullOrderDto> loadAllOrders();
    public Collection<FullOrderDto> loadUserOrders(Principal principal);
}
