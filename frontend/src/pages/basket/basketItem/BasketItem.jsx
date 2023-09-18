import React from 'react';
import cls from './BasketItem.module.css'
import plus from '../../../icons/plus--black.svg'
import minus from '../../../icons/minus--black.svg'
import {useDispatch} from "react-redux";
import {addProduct, deleteProduct} from "../../../store/reducers/basket/basket-slice";

const BasketItem = ({basketProduct}) => {
    const dispatch = useDispatch()

    const addToBasket = () => {
        dispatch(addProduct(basketProduct.product))
    }

    const deleteFromBasket = () => {
        dispatch(deleteProduct(basketProduct.product))
    }

    return (
        <div className={cls.mainBasketItemContainer}>
            <div className={cls.imageContainer}>
                <img className={cls.image} src={basketProduct.product.picture}/>
            </div>
            <div className={cls.basketProductItemContainer}>
                <div className={cls.title}>{basketProduct.product.product_name}</div>
                <div className={cls.pricePerUnit}>{basketProduct.product.price} ₽ за 1 шт</div>
                <div className={cls.priceContainer}>
                    <div className={cls.actualPrice}>
                        <span>{(basketProduct.product.offer ? basketProduct.product.offer.new_price : basketProduct.product.price) * basketProduct.count}</span>
                        <span> ₽</span>
                    </div>
                    { basketProduct.product.offer &&
                        <div className={cls.oldPrice}>
                            <span>{basketProduct.product.price * basketProduct.count}</span>
                            <span> ₽</span>
                        </div>
                    }
                </div>
                <div className={cls.buttonsMainContainer}>
                    <div className={cls.buttonsInnerContainer}>
                        <div className={cls.changeButtonContainer} onClick={deleteFromBasket}>
                            <img className={cls.changeButtonImage} src={minus}/>
                        </div>
                        <span>{basketProduct.count} шт</span>
                        <div className={cls.changeButtonContainer}>
                            <img className={cls.changeButtonImage} src={plus} onClick={addToBasket}/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default BasketItem;