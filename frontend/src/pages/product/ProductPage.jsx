import React from 'react';
import cls from './ProductPage.module.css'
import PageHeader from "../../components/header/PageHeader";
import {useParams} from "react-router-dom";
import ProductDetailInfo from "../../components/productDetailInfo/ProductDetailInfo";
import ProductDetailContent from "../../components/productDetailContent/ProductDetailContent";

const ProductPage = () => {
    const params = useParams()
    const product = {
        productName: 'Куриные яички',
        price: 180,
        picture: "https://www.cook-365.com/uploads/category_material/20200723072234-2020-07-23category_material072232.jpg",
        description: "Яйца категории СО больше, чем все остальные. Они крупные, отборные, свежие, все одного размера. В упаковке могут быть белые или коричневые яйца  — цвет скорлупы на вкус никак не влияет.",
        calories: 11,
        proteins: 4.0,
        brand: "Куриное зёрнышко",
        type: "Яйца",
        producer: "Куриная ферма",
        fats: 14.0,
        carbohydrates: 5.1,
        offer: {
            oldPrice: 200
        }
    }
    return (
        <div className={cls.productDetail}>
            <PageHeader>
                {params.productName}
            </PageHeader>
            <div className="container-main">
                <ProductDetailInfo product={product}/>
                <ProductDetailContent product={product}/>
            </div>
        </div>
    );
};

export default ProductPage;