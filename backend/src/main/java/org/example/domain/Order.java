package org.example.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.example.domain.Order.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@Getter
@Setter
public class Order {
    @Id
    @Column(name = ORDER_CODE_COLUMN_NAME)
    private UUID orderCode;
    @Column(name = DATE_COLUMN_NAME)
    private LocalDateTime date;
    @Column(name = USER_LOGIN_COLUMN_NAME)
    private String userLogin;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList;

    // region constants
    public static final String TABLE_NAME = "user_order";
    public static final String ORDER_CODE_COLUMN_NAME = "order_code";
    public static final String DATE_COLUMN_NAME = "date";
    public static final String USER_LOGIN_COLUMN_NAME = "user_login";
    // endregion
}
