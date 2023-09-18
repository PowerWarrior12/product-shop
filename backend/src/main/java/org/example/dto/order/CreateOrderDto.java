package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
public class CreateOrderDto {
    private final Collection<OrderItemDto> orderItemDtoCollection;

    public CreateOrderDto(
            @JsonProperty("items") Collection<OrderItemDto> orderItemDtoCollection) {
        this.orderItemDtoCollection = orderItemDtoCollection;
    }
}
