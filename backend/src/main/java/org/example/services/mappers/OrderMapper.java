package org.example.services.mappers;

import org.example.domain.Order;
import org.example.domain.OrderItem;
import org.example.domain.utils.OrderItemPrimaryKey;
import org.example.dto.order.CreateOrderDto;
import org.example.dto.order.FullOrderDto;
import org.example.dto.order.OrderItemDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class OrderMapper {
    public FullOrderDto orderToFullOrderDto(Order order) {
        return new FullOrderDto(
                order.getOrderCode(),
                order.getDate(),
                order.getOrderItemList()
                        .stream()
                        .map(this::orderItemToOrderItemDto)
                        .toList(),
                order.getUserLogin()
        );
    }

    public Order createOrderDtoToOrder(CreateOrderDto createOrderDto, String userLogin) {
        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setUserLogin(userLogin);
        return order;
    }

    public OrderItem orderItemDtoToOrderItem(OrderItemDto orderItemDto, UUID orderCode) {
        OrderItem orderItem = new OrderItem();
        OrderItemPrimaryKey primaryKey = new OrderItemPrimaryKey();
        primaryKey.setOrderCode(orderCode);
        primaryKey.setProductName(orderItemDto.getProductName());

        orderItem.setOrderItemKey(primaryKey);
        orderItem.setCount(orderItemDto.getCount());

        return orderItem;
    }

    public OrderItemDto orderItemToOrderItemDto(OrderItem orderItem) {
        return new OrderItemDto(
          orderItem.getOrderItemKey().getProductName(),
          orderItem.getCount()
        );
    }
}
