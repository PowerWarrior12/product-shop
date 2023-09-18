package org.example.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.utils.OrderItemPrimaryKey;

import static org.example.domain.OrderItem.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@Getter
@Setter
public class OrderItem {
    @EmbeddedId
    private OrderItemPrimaryKey orderItemKey;
    @Column(name = COUNT_COLUMN_NAME)
    private int count;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = ORDER_CODE_COLUMN_NAME, referencedColumnName = Order.ORDER_CODE_COLUMN_NAME, updatable = false, insertable = false)
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = PRODUCT_NAME_COLUMN_NAME, referencedColumnName = Product.PRODUCT_NAME_COLUMN_NAME, updatable = false, insertable = false)
    private Product product;
    // region constants
    public static final String TABLE_NAME = "order_item";
    public static final String ORDER_CODE_COLUMN_NAME = "order_code";
    public static final String PRODUCT_NAME_COLUMN_NAME = "product_name";
    public static final String COUNT_COLUMN_NAME = "item_count";
    // endregion
}
