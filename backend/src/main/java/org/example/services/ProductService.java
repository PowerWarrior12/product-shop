package org.example.services;

import org.example.dto.product.*;
import org.example.exceptions.AlreadyExistException;
import org.example.exceptions.ApiRequestException;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.NameNotFoundException;

public interface ProductService {
    public PageableProductDto loadProductsByFilterOrderAndPaging(OrderFilterPagingProductsRequest request);
    public FullProductDto createProduct(CreateProductDto productDto, MultipartFile picture) throws AlreadyExistException, ApiRequestException;
    public FullProductDto updateProduct(String productName, UpdateProductDto productDto, MultipartFile picture) throws AlreadyExistException, ApiRequestException, NameNotFoundException;
    public FullProductDto deleteProduct(String productName) throws NameNotFoundException;
}
