package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterDto;
import org.example.services.FilterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/filters")
public class FilterController {
    private final FilterService filterService;

    @PostMapping
    public ResponseEntity<Collection<FilterDto>> getFiltersByFilters(@RequestBody(required = false) Collection<FilterDto> filters) {
        return ResponseEntity.ok(filterService.loadFiltersByAppliedFilters(filters));
    }
}
