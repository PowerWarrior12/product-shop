package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Getter
public class FullOrderDto {
    private final UUID orderCode;
    private final LocalDateTime time;
    private final Collection<OrderItemDto> orderItemDtoCollection;
    private final String userLogin;

    public FullOrderDto(
            @JsonProperty("order_code") UUID orderCode,
            @JsonProperty("date") LocalDateTime time,
            @JsonProperty("items") Collection<OrderItemDto> orderItemDtoCollection,
            @JsonProperty("user_login") String userLogin) {
        this.orderCode = orderCode;
        this.time = time;
        this.orderItemDtoCollection = orderItemDtoCollection;
        this.userLogin = userLogin;
    }
}
