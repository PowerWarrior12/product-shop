package org.example.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OrderItemDto {
    private final String productName;
    private final int count;

    public OrderItemDto(
            @JsonProperty("product_name") String productName,
            @JsonProperty("count") int count) {
        this.productName = productName;
        this.count = count;
    }
}
