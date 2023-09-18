package org.example.dto.offer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FullOfferDto {

    private final String productName;
    private final int newPrice;
    private final boolean isAvailable;
    @JsonCreator
    public FullOfferDto(
            @JsonProperty("product_name") String productName,
            @JsonProperty("new_price") int newPrice,
            @JsonProperty("is_available") boolean isAvailable) {
        this.productName = productName;
        this.newPrice = newPrice;
        this.isAvailable = isAvailable;
    }
}
