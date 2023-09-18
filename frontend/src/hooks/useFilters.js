import {useEffect, useState} from "react";
import {useFetching} from "./useFetching";
import ProductRepository from "../repository/ProductRepository";

export const useFilters = () => {
    const [filters, setFilters] = useState([])
    const [selectedFilters, setSelectedFilters] = useState([])

    const [loadFilters, isFilterLoading, isFilterError] = useFetching(async (filters) => {
        const response = await ProductRepository.loadFilters(filters)
        setFilters(response.data)
    })

    useEffect(() => {
        loadFilters(selectedFilters)
    }, [selectedFilters])

    return [filters, isFilterLoading, isFilterError, selectedFilters, setSelectedFilters]
}