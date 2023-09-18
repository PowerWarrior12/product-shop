import React from 'react';
import cls from './OrderProductItem.module.css'

const OrderProductItem = ({orderProduct}) => {
    return (
        <div className={cls.orderProductItemContainer}>
            <span className={cls.productName}>{orderProduct.product_name} : </span>
            <span>{orderProduct.count} шт.</span>
        </div>
    );
};

export default OrderProductItem;