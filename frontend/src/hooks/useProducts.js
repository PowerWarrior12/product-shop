import {useFetching} from "./useFetching";
import ProductRepository from "../repository/ProductRepository";
import {useEffect, useMemo, useState} from "react";

export const useProducts = (page, selectedFilters, order) => {

    const filter = useMemo(() => {
        let brandFilter = selectedFilters.find((value) => value.filter_type === "Бренд")
        let brandFilterName = brandFilter ? brandFilter.values[0].name : null;
        let producerFilter = selectedFilters.find((value) => value.filter_type === "Производитель")
        let producerFilterName = producerFilter ? producerFilter.values[0].name : null;
        let categoryFilter = selectedFilters.find((value) => value.filter_type === "Категория")
        let categoryFilterName = categoryFilter ? categoryFilter.values[0].name : null;

        return {
            page_size: 10,
            page: page,
            brand_filter: brandFilterName,
            producer_filter: producerFilterName,
            category_filter: categoryFilterName,
            order_type: order
        }
    }, [page, selectedFilters, order])

    const [products, setProducts] = useState([]);

    const [loadProducts, isProductsLoading, productsError] = useFetching(async (filter) => {
        const response = await ProductRepository.load(filter)
        setProducts(response.data.products_page)
    })

    useEffect(() => {
        loadProducts(filter);
    }, [filter])

    return [products, isProductsLoading, productsError]
}