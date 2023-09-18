import React from 'react';
import cls from './OrderCard.module.css'
import OrderProductItem from "./orderProductItem/OrderProductItem";

const OrderCard = ({order}) => {

    const convertDate = (dateString) => {
        let date = new Date(dateString)
        return `${date.getFullYear()}.${date.getMonth()}.${date.getDay()} ${date.getHours()}:${date.getMinutes()}`
    }

    return (
        <div className={cls.orderCardContainer}>
            <h2 className={cls.orderCardTitle}>Заказ №{order.order_code}</h2>
            <div className={cls.orderCardDataContainer}>
                <h3 className={cls.orderCardPoint}>Дата: {convertDate(order.date)}</h3>
                <h3 className={cls.orderCardPoint}>Товары:</h3>
                <div className={cls.orderCardProductsContainer}>
                    {order.items.map(item =>
                        <OrderProductItem orderProduct={item}/>
                    )}
                </div>
            </div>
        </div>
    );
};

export default OrderCard;