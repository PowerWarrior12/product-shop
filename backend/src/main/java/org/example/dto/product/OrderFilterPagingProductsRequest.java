package org.example.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.enums.OrderType;

@Getter
public class OrderFilterPagingProductsRequest {
    private final int page;
    private final int pageSize;
    private final String brandFilterName;
    private final String categoryFilterName;
    private final String producerFilterName;
    private final OrderType orderType;
    public OrderFilterPagingProductsRequest(
            @JsonProperty("page") int page,
            @JsonProperty("page_size") int pageSize,
            @JsonProperty("brand_filter") String brandFilterName,
            @JsonProperty("category_filter") String categoryFilterName,
            @JsonProperty("producer_filter") String producerFilterName,
            @JsonProperty("order_type") OrderType orderType) {
        this.page = page;
        this.pageSize = pageSize;
        this.brandFilterName = brandFilterName;
        this.categoryFilterName = categoryFilterName;
        this.producerFilterName = producerFilterName;
        this.orderType = orderType;
    }
}
