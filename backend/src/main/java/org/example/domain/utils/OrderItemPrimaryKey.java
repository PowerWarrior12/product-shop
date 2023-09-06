package org.example.domain.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.OrderItem;

import java.util.UUID;

@Embeddable
@Setter
@Getter
public class OrderItemPrimaryKey {
    @Column(name = OrderItem.ORDER_CODE_COLUMN_NAME)
    private UUID orderCode;
    @Column(name = OrderItem.PRODUCT_NAME_COLUMN_NAME)
    private String productName;
}
