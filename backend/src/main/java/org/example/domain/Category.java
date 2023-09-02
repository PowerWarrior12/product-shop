package org.example.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static org.example.domain.Category.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@Getter
@Setter
public class Category {
    @Id
    @Column(name = CATEGORY_NAME_COLUMN_NAME)
    private String categoryName;

    // region constants
    public static final String TABLE_NAME = "category";
    public static final String CATEGORY_NAME_COLUMN_NAME = "category_name";
    // endregion
}
