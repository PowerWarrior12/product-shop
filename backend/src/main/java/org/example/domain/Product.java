package org.example.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;

import static org.example.domain.Product.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@Getter
@Setter
public class Product {
    @Id
    @Column(name = PRODUCT_NAME_COLUMN_NAME)
    private String productName;
    @Column(name = FOR_ADULTS_COLUMN_NAME)
    private boolean forAdults;
    @Column(name = PICTURE_COLUMN_NAME)
    private String pictureHref;
    @Column(name = IN_STOCK_COLUMN_NAME)
    private boolean inStock;
    @Column(name = PRICE_COLUMN_NAME)
    private int price;
    @Column(name = CATEGORY_NAME_COLUMN_NAME)
    private String categoryName;
    @Column(name = BRAND_NAME_COLUMN_NAME)
    private String brandName;
    @Column(name = PRODUCER_NAME_COLUMN_NAME)
    private String producerName;
    @Column(name = CAL_COLUMN_NAME)
    private int calories;
    @Column(name = PROTEINS_COLUMN_NAME)
    private BigDecimal proteins;
    @Column(name = FATS_COLUMN_NAME)
    private BigDecimal fats;
    @Column(name = DESCRIPTION_COLUMN_NAME)
    private String description;
    @Column(name = CARBOHYDRATES_COLUMN_NAME)
    private BigDecimal carbohydrates;
    @OneToOne(mappedBy = "product")
    private Offer offer;
    // region constants

    public static final String TABLE_NAME = "product";
    public static final String PRODUCT_NAME_COLUMN_NAME = "product_name";
    public static final String FOR_ADULTS_COLUMN_NAME = "for_adults";
    public static final String PICTURE_COLUMN_NAME = "picture";
    public static final String IN_STOCK_COLUMN_NAME = "in_stock";
    public static final String PRICE_COLUMN_NAME = "price";
    public static final String CATEGORY_NAME_COLUMN_NAME = "category_name";
    public static final String BRAND_NAME_COLUMN_NAME = "brand_name";
    public static final String PRODUCER_NAME_COLUMN_NAME = "producer_name";
    // calories
    public static final String CAL_COLUMN_NAME = "cal";
    public static final String PROTEINS_COLUMN_NAME = "proteins";
    public static final String FATS_COLUMN_NAME = "fats";
    public static final String DESCRIPTION_COLUMN_NAME = "description";
    public static final String CARBOHYDRATES_COLUMN_NAME = "carbohydrates";
    // endregion
}
