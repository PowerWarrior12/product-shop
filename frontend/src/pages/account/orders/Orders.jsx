import React, {useEffect, useState} from 'react';
import cls from './Orders.module.css'
import {useFetching} from "../../../hooks/useFetching";
import {OrderRepository} from "../../../repository/OrderRepository";
import OrderCard from "../../../components/orderCard/OrderCard";

const Orders = () => {

    const [orders, setOrders] = useState([])
    const [loadOrders, isLoading, error] = useFetching(async () => {
        let response = await OrderRepository.getOrders()
        setOrders(response.data)
    })

    useEffect(() => {
        loadOrders()
    }, [])

    return (
        <div className={cls.mainOrdersContainer}>
            <h1>Заказы</h1>
            {orders.length > 0 ?
                orders.map(order =>
                    <OrderCard order={order}/>
                ) : <h3 style={{margin: "13px"}}>Не порядок, ступай купи чё-нибудь!</h3>
            }
        </div>
    );
};

export default Orders;