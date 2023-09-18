import React from 'react';
import cls from "./ProductDetailContent.module.css";
import ProductCharacteristicElement from "./productCharacteristicElement/ProductCharacteristicElement";

const ProductDetailContent = ({product}) => {
    return (
        <div className={cls.productDetailContent}>
            <div className={cls.productDetailAbout}>
                <h3 className={cls.productDetailSubtitle}>
                    Описание
                </h3>
                <div>
                    {product.description}
                </div>
            </div>
            <div className={cls.productDetailCharacteristics}>
                <h2 className={cls.productCharacteristicsTitle}>Характеристики</h2>
                <ProductCharacteristicElement name="Тип продукта:" value={product.type}/>
                <ProductCharacteristicElement name="Бренд:" value={product.brand}/>
                <ProductCharacteristicElement name="Производитель:" value={product.producer}/>
            </div>
        </div>
    );
};

export default ProductDetailContent;