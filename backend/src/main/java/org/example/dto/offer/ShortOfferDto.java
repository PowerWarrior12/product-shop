package org.example.dto.offer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ShortOfferDto {
    private final int newPrice;
    private final boolean isAvailable;
    @JsonCreator
    public ShortOfferDto(
            @JsonProperty("new_price") int newPrice,
            @JsonProperty("is_available") boolean isAvailable) {
        this.newPrice = newPrice;
        this.isAvailable = isAvailable;
    }
}
