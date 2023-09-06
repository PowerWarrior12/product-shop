package org.example.dto.filter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class FilterValueDto {
    private final String name;
    private final boolean isChecked;
    public FilterValueDto(@JsonProperty("name") String name,
                          @JsonProperty("is_checked") boolean isChecked) {
        this.name = name;
        this.isChecked = isChecked;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FilterValueDto) {
            return name.equals(((FilterValueDto) obj).getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
