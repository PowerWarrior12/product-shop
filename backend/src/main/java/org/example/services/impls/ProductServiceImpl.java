package org.example.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.domain.Product;
import org.example.dto.product.*;
import org.example.enums.OrderType;
import org.example.exceptions.AlreadyExistException;
import org.example.repositories.ProductRepository;
import org.example.services.PictureService;
import org.example.services.ProductService;
import org.example.services.mappers.ProductMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.NameNotFoundException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final PictureService pictureService;

    /**
     * @return PageableProductDto with nextPage = -1 if hasNextPage is false
     */
    @Override
    @Transactional(readOnly = true)
    public PageableProductDto loadProductsByFilterOrderAndPaging(OrderFilterPagingProductsRequest request) {
        OrderType orderType = request.getOrderType();
        Sort sort = orderType != null ? Sort.by(Sort.Direction.ASC, orderType.toValue()) : Sort.unsorted();
        Pageable pageable = PageRequest.of(request.getPage(), request.getPageSize(), sort);
        Page<Product> productsPage = productRepository.loadProductsByOrderPageAnd(
                request.getBrandFilterName(),
                request.getCategoryFilterName(),
                request.getProducerFilterName(),
                pageable);
        boolean hasNextPage = productsPage.hasNext();
        return new PageableProductDto(
                productsPage
                        .map(productMapper::productToFullProductDto)
                        .toList(),
                hasNextPage,
                hasNextPage ? request.getPage() + 1 : -1
        );
    }

    @Override
    @Transactional
    public FullProductDto createProduct(CreateProductDto productDto, MultipartFile picture) {
        if (productRepository.existsById(productDto.getProductName())) {
            throw new AlreadyExistException(String.format("Product with product name: %s already exist", productDto.getProductName()));
        }
        String pictureHref = pictureService.savePicture(picture);
        Product createdProduct = productRepository.saveAndFlush(productMapper.createProductDtoToProduct(productDto, pictureHref));
        return productMapper.productToFullProductDto(createdProduct);
    }

    @Override
    public FullProductDto updateProduct(String productName, UpdateProductDto productDto, MultipartFile picture) throws NameNotFoundException {
        if (productDto.getProductName() != null && productRepository.existsById(productDto.getProductName())) {
            throw new AlreadyExistException(String.format("Product with product name: %s already exist", productDto.getProductName()));
        }
        if (productRepository.existsById(productName)) {
            throw new NameNotFoundException(String.format("Product with product name: %s didn't found", productName));
        }
        String pictureHref = pictureService.savePicture(picture);
        Product updatedProduct = productRepository.saveAndFlush(productMapper.updateProductDtoToProduct(productDto, pictureHref));
        return productMapper.productToFullProductDto(updatedProduct);
    }

    @Override
    @Transactional
    public FullProductDto deleteProduct(String productName) throws NameNotFoundException {
        Product product = productRepository.findById(productName).orElseThrow(() ->
                new NameNotFoundException(productName)
        );
        productRepository.deleteById(productName);
        return productMapper.productToFullProductDto(product);
    }
}
