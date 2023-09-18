import React from 'react';
import cls from './ProductList.module.css'
import ProductCard from "../productCard/ProductCard";

const ProductList = ({products}) => {
    return (
        <div className={cls.productList}>
            {products.map(product =>
                <ProductCard
                    key = {product.product_name}
                    product={product}
                />
            )}
        </div>
    );
};

export default ProductList;