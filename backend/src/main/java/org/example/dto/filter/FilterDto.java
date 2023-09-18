package org.example.dto.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Collection;
import java.util.Set;

@Getter
public class FilterDto {
    private String name;
    private Set<FilterValueDto> values;

    @JsonCreator
    public FilterDto(
            @JsonProperty("filter_type") String name,
            @JsonProperty("values") Set<FilterValueDto> values) {
        this.name = name;
        this.values = values;
    }
    @JsonIgnore
    public Collection<String> getValuesNames() {
        return values
                .stream()
                .map(FilterValueDto::getName)
                .toList();
    }
    // region constants
    public static final String BRAND_TYPE_NAME = "Бренд";
    public static final String PRODUCER_TYPE_NAME = "Производитель";
    public static final String CATEGORY_TYPE_NAME = "Категория";
    // endregion
}
