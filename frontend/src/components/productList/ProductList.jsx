import React from 'react';
import cls from './ProductList.module.css'
import ProductCard from "../productCard/ProductCard";

const ProductList = ({products}) => {
    return (
        <div className={cls.productList}>
            {products.map(product =>
                <ProductCard
                    key = {product.product_name}
                    image={product.picture}
                    description={product.product_name}
                    price={product.price}
                />
            )}
        </div>
    );
};

export default ProductList;