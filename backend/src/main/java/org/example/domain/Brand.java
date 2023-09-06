package org.example.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static org.example.domain.Brand.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@Getter
@Setter
public class Brand {
    @Id
    @Column(name = BRAND_NAME_COLUMN_NAME)
    private String brandName;
    @Column(name = VALUE_COUNT_COLUMN_NAME)
    private int valueCount;

    // region constants
    public static final String TABLE_NAME = "brand";
    public static final String BRAND_NAME_COLUMN_NAME = "brand_name";
    public static final String VALUE_COUNT_COLUMN_NAME = "value_count";
    // endregion
}
