package org.example.dto.product;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.dto.offer.ShortOfferDto;

@Getter
public class FullProductDto {
    private final String productName;
    private final boolean forAdults;
    private final boolean inStock;
    private final int price;
    private final String pictureHref;
    private final String categoryName;
    private final String brandName;
    private final String producerName;
    private final int calories;
    private final double proteins;
    private final double fats;
    private final String description;
    private final double carbohydrates;
    private final ShortOfferDto offer;

    @JsonCreator
    public FullProductDto(@JsonProperty("product_name") String productName,
                          @JsonProperty("for_adults") boolean forAdults,
                          @JsonProperty("is_stock") boolean inStock,
                          @JsonProperty("price") int price,
                          @JsonProperty("picture") String pictureHref,
                          @JsonProperty("category_name") String categoryName,
                          @JsonProperty("brand_name") String brandName,
                          @JsonProperty("producer_name") String producerName,
                          @JsonProperty("calories") int calories,
                          @JsonProperty("proteins") double proteins,
                          @JsonProperty("fats") double fats,
                          @JsonProperty("description") String description,
                          @JsonProperty("carbohydrates") double carbohydrates,
                          @JsonProperty("offer") ShortOfferDto offer) {
        this.productName = productName;
        this.forAdults = forAdults;
        this.inStock = inStock;
        this.price = price;
        this.pictureHref = pictureHref;
        this.categoryName = categoryName;
        this.brandName = brandName;
        this.producerName = producerName;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.description = description;
        this.carbohydrates = carbohydrates;
        this.offer = offer;
    }
}
