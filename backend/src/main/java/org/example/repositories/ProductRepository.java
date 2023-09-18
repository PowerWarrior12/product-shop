package org.example.repositories;

import org.example.domain.Product;
import org.example.repositories.projection.FilterProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT product" +
            " FROM Product product" +
            " LEFT JOIN FETCH product.offer" +
            " WHERE (:brandFilterName IS NULL OR product.brandName = :brandFilterName)" +
            " AND (:categoryFilterName IS NULL OR product.categoryName = :categoryFilterName)" +
            " AND (:producerFilterName IS NULL OR product.producerName = :producerFilterName)"
    )
    public Page<Product> loadProductsByOrderPageAnd(
            @Param("brandFilterName") @Nullable String brandFilterName,
            @Param("categoryFilterName") @Nullable String categoryFilterName,
            @Param("producerFilterName") @Nullable String producerFilterName,
            Pageable pageable);

    @Query("SELECT product.brandName AS brandName, product.categoryName AS categoryName, product.producerName AS producerName" +
            " FROM Product product" +
            " WHERE (:brandsIsEmpty = TRUE OR product.brandName in :brandsFilter)" +
            " AND (:categoriesIsEmpty = TRUE OR product.categoryName in :categoriesFilter)" +
            " AND (:producersIsEmpty = TRUE OR product.producerName in :producersFilter)")
    Collection<FilterProjection> findAllWithFiltersInMind (
            @Param("brandsFilter") @Nullable List<String> brandsFilter,
            @Param("brandsIsEmpty") boolean brandsIsEmpty,
            @Param("categoriesFilter") @Nullable List<String> categoriesFilter,
            @Param("categoriesIsEmpty") boolean categoriesIsEmpty,
            @Param("producersFilter") @Nullable List<String> producersFilter,
            @Param("producersIsEmpty") boolean producersIsEmpty
    );
}
