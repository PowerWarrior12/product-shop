package org.example.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.domain.Order;
import org.example.domain.OrderItem;
import org.example.dto.order.CreateOrderDto;
import org.example.dto.order.FullOrderDto;
import org.example.repositories.OrderItemRepository;
import org.example.repositories.OrderRepository;
import org.example.services.OrderService;
import org.example.services.mappers.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderMapper orderMapper;
    @Override
    @Transactional
    public FullOrderDto createOrder(CreateOrderDto createOrderDto, Principal principal) {
        Order createdOrder = orderRepository.saveAndFlush(orderMapper.createOrderDtoToOrder(createOrderDto, principal.getName()));
        Collection<OrderItem> orderItems = orderItemRepository.saveAllAndFlush(
                createOrderDto.getOrderItemDtoCollection()
                        .stream()
                        .map(orderItemDto -> orderMapper.orderItemDtoToOrderItem(orderItemDto, createdOrder.getOrderCode()))
                        .toList());
        createdOrder.setOrderItemList(orderItems);

        return orderMapper.orderToFullOrderDto(createdOrder);
    }

    @Override
    @Transactional
    public Collection<FullOrderDto> loadAllOrders() {
        return orderRepository
                .findAll()
                .stream()
                .map(orderMapper::orderToFullOrderDto)
                .toList();
    }

    @Override
    @Transactional
    public Collection<FullOrderDto> loadUserOrders(Principal principal) {
        return orderRepository
                .findAllByUserLogin(principal.getName())
                .stream()
                .map(orderMapper::orderToFullOrderDto)
                .toList();
    }
}
