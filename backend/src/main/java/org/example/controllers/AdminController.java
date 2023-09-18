package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dto.order.FullOrderDto;
import org.example.dto.product.CreateProductDto;
import org.example.dto.product.FullProductDto;
import org.example.dto.product.UpdateProductDto;
import org.example.exceptions.AlreadyExistException;
import org.example.exceptions.ApiRequestException;
import org.example.services.OrderService;
import org.example.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.NameNotFoundException;
import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final OrderService orderService;
    private final ProductService productService;
    @GetMapping("/orders")
    public ResponseEntity<Collection<FullOrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.loadAllOrders());
    }
    @PostMapping("/products/add")
    public ResponseEntity<FullProductDto> createProduct(
            @RequestPart(name = "picture", required = false) MultipartFile picture,
            @RequestPart(name = "product") CreateProductDto createProductDto,
            BindingResult bindingResult) throws AlreadyExistException, ApiRequestException {
        return ResponseEntity.ok(productService.createProduct(createProductDto, picture));
    }

    @PostMapping("/products/update/{product_name}")
    public ResponseEntity<FullProductDto> updateProduct(
            @RequestPart(name = "picture", required = false) MultipartFile picture,
            @RequestPart(name = "product") UpdateProductDto updateProductDto,
            @PathVariable("product_name") String productName,
            BindingResult bindingResult) throws NameNotFoundException {
        return ResponseEntity.ok(productService.updateProduct(productName, updateProductDto, picture));
    }

    @DeleteMapping("/products/delete/{product_name}")
    public ResponseEntity<FullProductDto> deleteProduct(
            @PathVariable("product_name") String productName) throws NameNotFoundException {
        return ResponseEntity.ok(productService.deleteProduct(productName));
    }
}
