package org.example.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Collection;

@Getter
public class PageableProductDto {
    private final Collection<FullProductDto> products;
    private final boolean hasNextPage;
    private final int nextPage;

    public PageableProductDto(
            @JsonProperty("products_page") Collection<FullProductDto> products,
            @JsonProperty("has_next_page") boolean hasNextPage,
            @JsonProperty("next_page") int nextPage) {
        this.products = products;
        this.hasNextPage = hasNextPage;
        this.nextPage = nextPage;
    }
}
