package org.example.repositories;

import io.github.yashchenkon.assertsqlcount.test.AssertSqlQueriesCount;
import org.assertj.core.groups.Tuple;
import org.example.common.TestDataGenerator;
import org.example.domain.Brand;
import org.example.domain.Category;
import org.example.domain.Producer;
import org.example.domain.Product;
import org.example.repositories.projection.FilterProjection;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@TestPropertySource("/application-test.properties")
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    private static List<Producer> testProducers = TestDataGenerator.generateProducers();
    private static List<Brand> testBrands = TestDataGenerator.generateBrands();
    private static List<Category> testCategories = TestDataGenerator.generateCategories();
    private static List<Product> testProducts = TestDataGenerator.generateProducts(20);

    @BeforeEach
    public void setUp() {
        testProducers.forEach((producer -> testEntityManager.persist(producer)));
        testBrands.forEach((brand -> testEntityManager.persist(brand)));
        testCategories.forEach((category -> testEntityManager.persist(category)));
        testEntityManager.flush();

        testProducts.forEach(product -> testEntityManager.persist(product));
        testEntityManager.flush();
    }

    @BeforeEach
    public void prepare() {
        AssertSqlQueriesCount.reset();
    }

    @Test
    @DisplayName("load products by filters, pageable and order with null filters")
    public void loadProductsByOrderPageAnd_WithNullFilter() {
        Pageable pageable = Pageable.ofSize(5).withPage(1);
        Page<Product> result = productRepository.loadProductsByOrderPageAnd(null, null, null, pageable);
        List<Product> productsList = result.stream().toList();
        assertEquals(productsList.size(), 5);

        for (int i = 0; i < productsList.size(); i++) {
            assertEquals(productsList.get(i).getProductName(), String.format("Product%d", i + 5));
        }

        AssertSqlQueriesCount.assertSelectCount(2);
    }

    @Test
    @DisplayName("load products by filters, pageable and order with filters")
    public void loadProductsByOrderPageAnd_WithFilter() {
        Pageable pageable = Pageable.ofSize(5).withPage(0);
        Page<Product> result = productRepository.loadProductsByOrderPageAnd("B1", null, "P5", pageable);
        List<Product> productsList = result.stream().toList();
        assertEquals(productsList.size(), 4);

        assertThat(productsList).extracting(Product::getBrandName, Product::getProducerName).contains(tuple("B1", "P5"));

        AssertSqlQueriesCount.assertSelectCount(1);
    }

    @Test
    @DisplayName("find all with filters in mind")
    public void findAllWithFiltersInMind() {
        Collection<FilterProjection> result = productRepository.findAllWithFiltersInMind(
                List.of("B1"),
                false,
                Collections.emptyList(),
                true,
                Collections.emptyList(),
                true
        );
        assertThat(result)
                .hasSize(4)
                .extracting(FilterProjection::getBrandName)
                    .contains("B1");


        AssertSqlQueriesCount.assertSelectCount(1);
    }

}