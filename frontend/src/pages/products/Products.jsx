import React, {useState} from 'react';
import cls from './Products.module.css'
import PageHeader from "../../components/header/PageHeader";
import ProductList from "../../components/productList/ProductList";
import FilterBoxes from "../../components/filterBoxes/FilterBoxes";
import SortingComponent from "../../components/sortingComponent/SortingComponent";
import {CircularProgress} from "@mui/material";
import {useFilters} from "../../hooks/useFilters";
import {useProducts} from "../../hooks/useProducts";
import {sorts} from "../../constants/commonConstants";

const Products = () => {
    const [filters, isFilterLoading, isFilterError, selectedFilters, setSelectedFilters] = useFilters()
    const [sort, setSort] = useState(null)
    const [products, isProductLoading, productError] = useProducts(null, selectedFilters, sort)

    return (
        <div>
            <PageHeader>
                Каталог
            </PageHeader>
            { isProductLoading
                ? <div className={cls.loadingBarContainer}> <CircularProgress/> </div>
                : <div className={cls.mainContainer}>
                    <FilterBoxes filterBoxes={filters} setSelectedFilters={setSelectedFilters} selectedFilters={selectedFilters}/>
                    <div>
                        <SortingComponent sorts={sorts} currentSort={sort} setCurrentSort={setSort}/>
                        <ProductList products={products}/>
                    </div>
                </div>
            }
        </div>
    );
};

export default Products;