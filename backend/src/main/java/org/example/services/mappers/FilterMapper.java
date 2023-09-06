package org.example.services.mappers;

import org.example.dto.filter.FilterDto;
import org.example.dto.filter.FilterValueDto;
import org.example.repositories.projection.FilterProjection;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

@Component
public class FilterMapper {
    public Collection<FilterDto> filterProjectionsToFilterDtoCollection(Collection<FilterProjection> filterProjections) {
        FilterDto[] filterDtoCollection = {
                new FilterDto(FilterDto.BRAND_TYPE_NAME, new HashSet<>()),
                new FilterDto(FilterDto.CATEGORY_TYPE_NAME, new HashSet<>()),
                new FilterDto(FilterDto.PRODUCER_TYPE_NAME, new HashSet<>()) };
        filterProjections.forEach(filterProjection -> {
            filterDtoCollection[0].getValues().add(new FilterValueDto(filterProjection.getBrandName(), false));
            filterDtoCollection[1].getValues().add(new FilterValueDto(filterProjection.getCategoryName(), false));
            filterDtoCollection[2].getValues().add(new FilterValueDto(filterProjection.getProducerName(), false));
        });
        return Arrays.stream(filterDtoCollection).toList();
    }
}
