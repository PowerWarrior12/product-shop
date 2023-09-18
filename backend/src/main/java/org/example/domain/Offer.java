package org.example.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static org.example.domain.Offer.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@Getter
@Setter
public class Offer {
    @Id
    @Column(name = PRODUCT_NAME_COLUMN_NAME)
    private String productName;
    @Column(name = NEW_PRICE_COLUMN_NAME)
    private int newPrice;
    @Column(name = IS_AVAILABLE_COLUMN_NAME)
    private boolean isAvailable;
    @MapsId(PRODUCT_NAME_COLUMN_NAME)
    @OneToOne
    @JoinColumn(name = PRODUCT_NAME_COLUMN_NAME, referencedColumnName = Product.PRODUCT_NAME_COLUMN_NAME, insertable = false, updatable = false)
    private Product product;
    // region constants
    public static final String TABLE_NAME = "offer";
    public static final String PRODUCT_NAME_COLUMN_NAME = "product_name";
    public static final String NEW_PRICE_COLUMN_NAME = "new_price";
    public static final String IS_AVAILABLE_COLUMN_NAME = "is_available";
    // endregion
}
