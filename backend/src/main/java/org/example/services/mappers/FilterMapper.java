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
    public Collection<FilterDto> filterProjectionsToFilterDtoCollection(Collection<FilterProjection> filterProjections,
                                                                        Collection<FilterDto> inputFilters) {
        FilterDto[] filterDtoCollection = {
                new FilterDto(FilterDto.BRAND_TYPE_NAME, new HashSet<>()),
                new FilterDto(FilterDto.CATEGORY_TYPE_NAME, new HashSet<>()),
                new FilterDto(FilterDto.PRODUCER_TYPE_NAME, new HashSet<>())};

        FilterDto inputBrandFilter = inputFilters.stream()
                .filter(filterDto -> filterDto.getName().equals(FilterDto.BRAND_TYPE_NAME))
                .findFirst()
                .orElse(null);

        FilterDto inputCategoryFilter = inputFilters.stream()
                .filter(filterDto -> filterDto.getName().equals(FilterDto.CATEGORY_TYPE_NAME))
                .findFirst()
                .orElse(null);

        FilterDto inputProducerFilter = inputFilters.stream()
                .filter(filterDto -> filterDto.getName().equals(FilterDto.PRODUCER_TYPE_NAME))
                .findFirst()
                .orElse(null);

        filterProjections.forEach(filterProjection -> {
            filterDtoCollection[0].getValues().add(new FilterValueDto(filterProjection.getBrandName(), inputBrandFilter != null && inputBrandFilter.getValuesNames().contains(filterProjection.getBrandName())));
            filterDtoCollection[1].getValues().add(new FilterValueDto(filterProjection.getCategoryName(), inputCategoryFilter != null && inputCategoryFilter.getValuesNames().contains(filterProjection.getCategoryName())));
            filterDtoCollection[2].getValues().add(new FilterValueDto(filterProjection.getProducerName(), inputProducerFilter != null && inputProducerFilter.getValuesNames().contains(filterProjection.getProducerName())));
        });
        return Arrays.stream(filterDtoCollection).toList();
    }
}
