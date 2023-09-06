package org.example.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterDto;
import org.example.repositories.ProductRepository;
import org.example.repositories.projection.FilterProjection;
import org.example.services.FilterService;
import org.example.services.mappers.FilterMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.example.dto.filter.FilterDto.BRAND_TYPE_NAME;
import static org.example.dto.filter.FilterDto.PRODUCER_TYPE_NAME;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {
    private final ProductRepository productRepository;
    private final FilterMapper filterMapper;

    @Transactional
    @Override
    public Collection<FilterDto> loadFiltersByAppliedFilters(Iterable<FilterDto> inputFilters) {
        List<String> brandNames = new ArrayList<>();
        List<String> categoryNames = new ArrayList<>();
        List<String> producerNames = new ArrayList<>();
        inputFilters.forEach(filterDto -> {
            switch (filterDto.getName()) {
                case BRAND_TYPE_NAME:
                    brandNames.addAll(filterDto.getValuesNames());
                    break;
                case PRODUCER_TYPE_NAME:
                    producerNames.addAll(filterDto.getValuesNames());
                default:
                    categoryNames.addAll(filterDto.getValuesNames());
                    break;
            }
        });
        Collection<FilterProjection> filters = productRepository.findAllWithFiltersInMind(
                brandNames,
                brandNames.isEmpty(),
                categoryNames,
                categoryNames.isEmpty(),
                producerNames,
                producerNames.isEmpty());

        return filterMapper.filterProjectionsToFilterDtoCollection(filters);
    }
}
