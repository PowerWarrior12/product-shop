package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collection;

@Getter
public class CreateOrderDto {
    private final LocalDateTime time;
    private final Collection<OrderItemDto> orderItemDtoCollection;

    public CreateOrderDto(
            @JsonProperty("date") LocalDateTime time,
            @JsonProperty("items") Collection<OrderItemDto> orderItemDtoCollection) {
        this.time = time;
        this.orderItemDtoCollection = orderItemDtoCollection;
    }
}
