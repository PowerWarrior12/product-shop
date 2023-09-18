import React from 'react';
import cls from './Basket.module.css'
import BasketItem from "./basketItem/BasketItem";
import {useSelector} from "react-redux";
import {selectBasketProductsFromBasket} from "../../store/reducers/basket/basket-selector";
import SecondaryButton from "../../components/UI/secondaryButton/SecondaryButton";
import {useNavigate} from "react-router-dom";
import {OrderRepository} from "../../repository/OrderRepository";

const Basket = () => {
    const basketProducts = useSelector(selectBasketProductsFromBasket)
    const router = useNavigate()

    const processCreateOrder = () => {
        let creatingOrder = {
            date: new Date(),
            items: Array.from(basketProducts.values()).map(basketProduct => {
                    return {
                        product_name: basketProduct.product.product_name,
                        count: basketProduct.count
                    }
                }
            )
        }
        OrderRepository.createOrder(creatingOrder).then(() => {
            router("/")
        }, () => {

        })
    }

    return (
        <div className={cls.basketLayout}>
            <div className={cls.basketLayoutLeft}>
                <div className={cls.basketHeader}>
                    <h3 className={cls.title}>Корзина</h3>
                </div>
                <div>
                    {Array.from(basketProducts.values()).map(basketProduct =>
                        <BasketItem basketProduct={basketProduct}/>
                    )}
                </div>
            </div>
            <div className={cls.basketLayoutRight}>
                <div className={cls.orderProperties}>
                    <div className={cls.orderProperty}>
                        <span>{Array.from(basketProducts.values()).length} товаров</span>
                        <span>{Array.from(basketProducts.values()).reduce((accumulator, currentValue) => {
                            return accumulator + currentValue.count * currentValue.product.price
                        }, 0)} ₽</span>
                    </div>
                    <div className={cls.orderProperty}>
                        <span>Скидка</span>
                        <span>- {Array.from(basketProducts.values()).reduce((accumulator, currentValue) => {
                            return accumulator + currentValue.count * (currentValue.product.offer ? currentValue.product.offer.new_price - currentValue.product.price : 0)
                        }, 0)} ₽</span>
                    </div>
                    <div className={[cls.orderProperty, cls.bigOrderProperty].join(' ')}>
                        <span>Итого</span>
                        <span>{Array.from(basketProducts.values()).reduce((accumulator, currentValue) => {
                            return accumulator + currentValue.count *
                                (currentValue.product.offer ? currentValue.product.offer.new_price : currentValue.product.price)
                        }, 0)} ₽</span>
                    </div>
                </div>
                <div className={cls.createOrderButtonContainer}>
                    <SecondaryButton onClick={processCreateOrder}>
                        <span className={cls.buttonText}>Оформить заказ</span>
                    </SecondaryButton>
                </div>
            </div>
        </div>

    );
};

export default Basket;