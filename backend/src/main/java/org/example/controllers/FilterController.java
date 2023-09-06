package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.filter.FilterDto;
import org.example.services.FilterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/filters")
public class FilterController {
    private final FilterService filterService;
    @GetMapping
    public ResponseEntity<Collection<FilterDto>> getFiltersByFilters(@RequestBody Collection<FilterDto> filters) {
        return ResponseEntity.ok(filterService.loadFiltersByAppliedFilters(filters));
    }
}