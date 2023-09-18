import React from 'react';
import cls from './ProductCard.module.css'
import PrimaryButton from "../UI/primaryButton/PrimaryButton";
import {useNavigate} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {selectBasketProductsFromBasket} from "../../store/reducers/basket/basket-selector";
import AddDeleteButton from "../UI/addDeleteButton/AddDeleteButton";
import {addProduct, deleteProduct} from "../../store/reducers/basket/basket-slice";

const ProductCard = ({product}) => {
    const router = useNavigate()
    const basketProducts = useSelector(selectBasketProductsFromBasket)
    const dispatch = useDispatch()

    const addToBasket = () => {
        dispatch(addProduct(product))
    }

    const deleteFromBasket = () => {
        dispatch(deleteProduct(product))
    }

    return (
        <div className={cls.productCard} onClick={() => router(`/products/${product.product_name}`)}>
            <div className={cls.productCardInner}>
                <div className={cls.productCardPhoto}>
                    <img src={product.picture} loading='lazy' className={cls.photo}/>
                </div>
                <div className={cls.productCardDescription}>
                    {product.product_name}
                </div>
                <div className={cls.productCardPrice}>
                    <div className={cls.productItemPrice}>
                        <span>{product.price}</span>
                        <span className={cls.currency}>₽</span>
                    </div>
                </div>

                <div className={cls.productCardButtons} onClick={(e) => e.stopPropagation()}>
                    {!basketProducts.has(product.product_name) ?
                        <PrimaryButton onClick={addToBasket}>
                            <span>В корзину</span>
                        </PrimaryButton>
                        : <AddDeleteButton count={basketProducts.get(product.product_name).count} onMinusClick={deleteFromBasket} onPlusClick={addToBasket}/>
                    }
                </div>
            </div>
        </div>
    );
};

export default ProductCard;