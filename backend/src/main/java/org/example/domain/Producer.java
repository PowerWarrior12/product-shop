package org.example.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import static org.example.domain.Producer.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@Getter
@Setter
public class Producer {
    @Id
    @Column(name = PRODUCER_NAME_COLUMN_NAME)
    private String categoryName;

    // region constants
    public static final String TABLE_NAME = "producer";
    public static final String PRODUCER_NAME_COLUMN_NAME = "producer_name";
    // endregion
}
