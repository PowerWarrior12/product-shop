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
import PaginationMoreBlock from "../../components/paginator/PaginationMoreBlock";

const Products = () => {

    const [filters, isFilterLoading, isFilterError, selectedFilters, setSelectedFilters] = useFilters()
    const [sort, setSort] = useState(null)
    const [page, setPage] = useState(0)
    const [products, isProductLoading, productError] = useProducts(page, setPage, selectedFilters, sort)

    const updatePage = () => {
        setPage(page + 1)
    }

    return (
        <div>
            <PageHeader>
                Каталог
            </PageHeader>
            {isProductLoading && <div className={cls.loadingBarContainer}><CircularProgress/></div>}
            <div className="container-main">
                <div className={cls.mainContainer}>
                    <FilterBoxes filterBoxes={filters} setSelectedFilters={setSelectedFilters}
                                 selectedFilters={selectedFilters}/>
                    <div className={cls.sectionProducts}>
                        <SortingComponent sorts={sorts} currentSort={sort} setCurrentSort={setSort}/>
                        <ProductList products={products.productsPage}/>
                        { products.hasNextPage && <PaginationMoreBlock onClick={updatePage}/> }
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Products;