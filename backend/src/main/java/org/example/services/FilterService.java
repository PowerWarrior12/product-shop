package org.example.services;

import org.example.dto.filter.FilterDto;

import java.util.Collection;

public interface FilterService {
    public Collection<FilterDto> loadFiltersByAppliedFilters(Iterable<FilterDto> inputFilters);
}
