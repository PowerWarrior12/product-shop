import {useFetching} from "./useFetching";
import ProductRepository from "../repository/ProductRepository";
import {useEffect, useMemo, useRef, useState} from "react";

export const useProducts = (page, setPage, selectedFilters, order) => {

    const [filterOrderingPaging, setFilterOrderPaging] = useState(
        {
            filters: selectedFilters,
            order: order,
            page: page
        }
    )

    const filter = useMemo(() => {
        let brandFilter = filterOrderingPaging.filters.find((value) => value.filter_type === "Бренд")
        let brandFilterName = brandFilter ? brandFilter.values[0].name : null;
        let producerFilter = filterOrderingPaging.filters.find((value) => value.filter_type === "Производитель")
        let producerFilterName = producerFilter ? producerFilter.values[0].name : null;
        let categoryFilter = filterOrderingPaging.filters.find((value) => value.filter_type === "Категория")
        let categoryFilterName = categoryFilter ? categoryFilter.values[0].name : null;

        return {
                page_size: 4,
                page: filterOrderingPaging.page,
                brand_filter: brandFilterName,
                producer_filter: producerFilterName,
                category_filter: categoryFilterName,
                order_type: filterOrderingPaging.order
        }
    }, [filterOrderingPaging])

    useEffect(() => {
        setFilterOrderPaging({...filterOrderingPaging, page: page})
    }, [page])

    useEffect(() => {
        setPage(0)
        setFilterOrderPaging({ ...filterOrderingPaging, order: order, filters: selectedFilters, page: 0})
    }, [selectedFilters, order])

    const [products, setProducts] = useState([]);

    const [loadProducts, isProductsLoading, productsError] = useFetching(async (filter) => {
        const response = await ProductRepository.load(filter)
        const newProducts = page === 0 ? response.data.products_page : [...products, ...response.data.products_page]
        setProducts(newProducts)
    })

    useEffect(() => {
        loadProducts(filter);
        console.log("PIPA")
    }, [filter])

    return [products, isProductsLoading, productsError]
}