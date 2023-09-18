package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.product.OrderFilterPagingProductsRequest;
import org.example.dto.product.PageableProductDto;
import org.example.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    @PostMapping("/custom-filter")
    public ResponseEntity<PageableProductDto> getProductsByFilterOrderAndPaging(
            @RequestBody OrderFilterPagingProductsRequest request,
            BindingResult bindingResult
    ) {
        return ResponseEntity.ok(productService.loadProductsByFilterOrderAndPaging(request));
    }

    @ExceptionHandler
    public String handle(Exception exception) {
        return exception.getMessage();
    }
}
