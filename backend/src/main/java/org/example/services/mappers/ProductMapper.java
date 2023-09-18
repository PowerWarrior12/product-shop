package org.example.services.mappers;

import lombok.RequiredArgsConstructor;
import org.example.domain.Offer;
import org.example.domain.Product;
import org.example.dto.product.CreateProductDto;
import org.example.dto.product.FullProductDto;
import org.example.dto.product.UpdateProductDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class ProductMapper {
    private final OfferMapper offerMapper;
    public FullProductDto productToFullProductDto(Product product) {
        Offer offer = product.getOffer();
        return new FullProductDto(
                product.getProductName(),
                product.isForAdults(),
                product.isInStock(),
                product.getPrice(),
                product.getPictureHref(),
                product.getCategoryName(),
                product.getBrandName(),
                product.getProducerName(),
                product.getCalories(),
                product.getProteins().doubleValue(),
                product.getFats().doubleValue(),
                product.getDescription(),
                product.getCarbohydrates().doubleValue(),
                offer != null ? offerMapper.offerToShortOfferDto(product.getOffer()) : null
        );
    }

    public Product createProductDtoToProduct(CreateProductDto productDto, String pictureHref) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setCalories(productDto.getCalories());
        product.setFats(BigDecimal.valueOf(productDto.getFats()));
        product.setCarbohydrates(BigDecimal.valueOf(productDto.getCarbohydrates()));
        product.setDescription(productDto.getDescription());
        product.setBrandName(productDto.getBrandName());
        product.setForAdults(productDto.isForAdults());
        product.setCategoryName(productDto.getCategoryName());
        product.setInStock(productDto.isInStock());
        product.setPictureHref(pictureHref);
        product.setPrice(productDto.getPrice());
        product.setProducerName(productDto.getProducerName());
        product.setProteins(BigDecimal.valueOf(productDto.getProteins()));

        return product;
    }
    public Product updateProductDtoToProduct(UpdateProductDto productDto, String pictureHref) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setCalories(productDto.getCalories());
        product.setFats(BigDecimal.valueOf(productDto.getFats()));
        product.setCarbohydrates(BigDecimal.valueOf(productDto.getCarbohydrates()));
        product.setDescription(productDto.getDescription());
        product.setBrandName(productDto.getBrandName());
        product.setForAdults(productDto.isForAdults());
        product.setCategoryName(productDto.getCategoryName());
        product.setInStock(productDto.isInStock());
        product.setPictureHref(pictureHref);
        product.setPrice(productDto.getPrice());
        product.setProducerName(productDto.getProducerName());
        product.setProteins(BigDecimal.valueOf(productDto.getProteins()));

        return product;
    }
}
