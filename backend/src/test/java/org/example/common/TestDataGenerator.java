package org.example.common;

import org.example.domain.*;
import org.example.dto.offer.ShortOfferDto;
import org.example.dto.order.FullOrderDto;
import org.example.dto.order.OrderItemDto;
import org.example.dto.product.CreateProductDto;
import org.example.dto.product.FullProductDto;
import org.example.enums.Role;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class TestDataGenerator {
    public final static UUID TEST_UUID = UUID.fromString("6c5e7071-b1b7-4b59-b07d-f16b33918568");
    public final static LocalDateTime TEST_DATE = LocalDateTime.of(2023, 10, 20, 10, 10, 10);
    public final static String TEST_PRODUCT_NAME = "Product";
    public final static int TEST_PRODUCT_COUNT = 2;
    public final static boolean TEST_FOR_ADULTS = true;
    public final static boolean TEST_IS_STOCK = false;
    public final static int TEST_PRICE = 100;
    public final static String TEST_BRAND_NAME = "Brand";
    public final static String TEST_PRODUCER_NAME = "Producer";
    public final static String TEST_CATEGORY_NAME = "Category";
    public final static int TEST_CALORIES = 30;
    public final static double TEST_FATS = 10.0;
    public final static double TEST_PROTEINS = 15.0;
    public final static double TEST_CARBOHYDRATES = 20.0;
    public final static String TEST_DESCRIPTION = "Description";
    public final static String TEST_EMAIL = "test@mail.ru";
    public final static String TEST_FILE_NAME = "file";
    public final static String TEST_FILE_EXTENSION = "png";
    public final static boolean TEST_IS_AVAILABLE = true;
    private final static Random random = new Random();

    private static List<String> generateProducersNames() {
        return List.of("P5", "P4", "P3", "P2", "P1");
    }

    private static List<String> generateCategoryNames() {
        return List.of("C1", "C2", "C3", "C4");
    }

    private static List<String> generateBrandNames() {
        return List.of("B1", "B2", "B3", "B4", "B5");
    }

    public static User generateUser() {
        User user = new User();
        user.setLogin(TEST_EMAIL);
        user.setName("Name");
        user.setLastName("Lastname");
        user.setPassword("password");
        user.setRoles(List.of(generateRole()));
        user.setPhoneNumber("+77777777777");
        return user;
    }

    public static Role generateRole() {
        return Role.ROLE_CUSTOMER;
    }

    public static List<Producer> generateProducers() {
        return generateProducersNames().stream().map((producerName) -> {
                    Producer producer = new Producer();
                    producer.setCategoryName(producerName);
                    producer.setValueCount(3);
                    return producer;
                }
        ).toList();
    }

    public static List<Brand> generateBrands() {
        return generateBrandNames().stream().map((brandName) -> {
                    Brand brand = new Brand();
                    brand.setBrandName(brandName);
                    brand.setValueCount(3);
                    return brand;
                }
        ).toList();
    }

    public static List<Category> generateCategories() {
        return generateCategoryNames().stream().map((categoryName) -> {
                    Category brand = new Category();
                    brand.setCategoryName(categoryName);
                    brand.setValueCount(3);
                    return brand;
                }
        ).toList();
    }

    public static List<Product> generateProducts(int count) {
        List<Product> products = new ArrayList<>();
        List<String> producers = generateProducersNames();
        List<String> categories = generateCategoryNames();
        List<String> brands = generateBrandNames();
        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.setProteins(BigDecimal.valueOf(10.0));
            product.setPrice(100 * (i % 3));
            product.setProducerName(producers.get(i % producers.size()));
            product.setFats(BigDecimal.valueOf(3.3 * (i % 4)));
            product.setInStock(random.nextBoolean());
            product.setProductName(String.format("%s%d", TEST_PRODUCT_NAME, i));
            product.setPictureHref(UUID.randomUUID().toString());
            product.setCategoryName(categories.get(i % categories.size()));
            product.setForAdults(random.nextBoolean());
            product.setDescription(String.format("Description%d", i));
            product.setBrandName(brands.get(i % brands.size()));
            product.setCalories(4 * (i % 5));
            product.setCarbohydrates(BigDecimal.valueOf(3.3 * (i % 4)));
            products.add(product);
        }
        return products;
    }

    public static Collection<FullOrderDto> generateFullOrders() {
        return List.of(
                new FullOrderDto(TEST_UUID, TEST_DATE, List.of(
                        new OrderItemDto(TEST_PRODUCT_NAME, TEST_PRODUCT_COUNT)
                ), TEST_EMAIL)
        );
    }

    public static CreateProductDto generateCreateProductDto() {
        return new CreateProductDto(
                TEST_PRODUCT_NAME,
                TEST_FOR_ADULTS,
                TEST_IS_STOCK,
                TEST_PRICE,
                TEST_CATEGORY_NAME,
                TEST_BRAND_NAME,
                TEST_PRODUCER_NAME,
                TEST_CALORIES,
                TEST_PROTEINS,
                TEST_FATS,
                TEST_DESCRIPTION,
                TEST_CARBOHYDRATES
        );
    }

    public static ShortOfferDto generateShortOfferDto() {
        return new ShortOfferDto(
                TEST_PRICE,
                TEST_IS_AVAILABLE
        );
    }

    public static FullProductDto generateFullProductDto(String host) {
        return new FullProductDto(
                TEST_PRODUCT_NAME,
                TEST_FOR_ADULTS,
                TEST_IS_STOCK,
                TEST_PRICE,
                String.format("%s/%s.%s", host, TEST_FILE_NAME, TEST_FILE_EXTENSION),
                TEST_CATEGORY_NAME,
                TEST_BRAND_NAME,
                TEST_PRODUCER_NAME,
                TEST_CALORIES,
                TEST_PROTEINS,
                TEST_FATS,
                TEST_DESCRIPTION,
                TEST_CARBOHYDRATES,
                generateShortOfferDto()
        );
    }

}
