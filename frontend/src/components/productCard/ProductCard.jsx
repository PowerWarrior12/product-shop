import React from 'react';
import cls from './ProductCard.module.css'
import PrimaryButton from "../UI/primaryButton/PrimaryButton";
import {useNavigate} from "react-router-dom";

const ProductCard = ({image, description, price}) => {
    const router = useNavigate()
    return (
        <div className={cls.productCard} onClick={() => router(`/products/${description}`)}>
            <div className={cls.productCardInner}>
                <div className={cls.productCardPhoto}>
                    <img src={image} loading='lazy' className={cls.photo}/>
                </div>
                <div className={cls.productCardDescription}>
                    {description}
                </div>
                <div className={cls.productCardPrice}>
                    <div className={cls.productItemPrice}>
                        <span>{price}</span>
                        <span className={cls.currency}>₽</span>
                    </div>
                </div>
                <div className={cls.productCardButtons}>
                    <PrimaryButton onClick={() => console.log("")}>
                        <span>В корзину</span>
                    </PrimaryButton>
                </div>
            </div>
        </div>
    );
};

export default ProductCard;