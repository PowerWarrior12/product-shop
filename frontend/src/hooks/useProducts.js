import {useFetching} from "./useFetching";
import ProductRepository from "../repository/ProductRepository";
import {useEffect, useRef, useState} from "react";
import {isEqual} from "lodash";

export const useProducts = (page, setPage, selectedFilters, order) => {
    const [filter, setFilter] = useState(
        {
            filters: selectedFilters,
            order: order,
            page: page
        }
    )

    const prevFilter = useRef()

    useEffect(() => {
        setFilter({...filter, page: page})
    }, [page])

    useEffect(() => {
        setPage(0)
        setFilter({ ...filter, order: order, filters: selectedFilters, page: 0})
    }, [selectedFilters, order])

    const [products, setProducts] = useState({
        hasNextPage: true,
        productsPage: []
    });

    const [loadProducts, isProductsLoading, productsError] = useFetching(async (filter) => {
        const response = await ProductRepository.load(filter)
        const newProducts = page === 0 ?
            {
                hasNextPage : response.data.has_next_page,
                productsPage: response.data.products_page
            }: {
                hasNextPage: response.data.has_next_page,
                productsPage: [...products.productsPage, ...response.data.products_page]
            }
        setProducts(newProducts)
    })

    useEffect(() => {
        if (!isEqual(prevFilter.current, filter)) {
            prevFilter.current = filter

            let brandFilter = filter.filters.find((value) => value.filter_type === "Бренд")
            let brandFilterName = brandFilter ? brandFilter.values[0].name : null;
            let producerFilter = filter.filters.find((value) => value.filter_type === "Производитель")
            let producerFilterName = producerFilter ? producerFilter.values[0].name : null;
            let categoryFilter = filter.filters.find((value) => value.filter_type === "Категория")
            let categoryFilterName = categoryFilter ? categoryFilter.values[0].name : null;

            loadProducts({
                page_size: 4,
                page: filter.page,
                brand_filter: brandFilterName,
                producer_filter: producerFilterName,
                category_filter: categoryFilterName,
                order_type: filter.order
            });
        }
    }, [filter])

    return [products, isProductsLoading, productsError]
}