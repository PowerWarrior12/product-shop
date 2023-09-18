import React from 'react';
import cls from "./ProductCharacteristicElement.module.css";

const ProductCharacteristicElement = ({name, value}) => {
    return (
        <div className={cls.productCharacteristicsElement}>
            <span className={cls.productCharacteristicsName}>{name}</span>
            <span className={cls.productCharacteristicsValue}>{value}</span>
        </div>
    );
};

export default ProductCharacteristicElement;