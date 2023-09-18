import React from 'react';
import PrimaryButton from "../UI/primaryButton/PrimaryButton";
import cls from "./ProductDetailInfo.module.css"

const ProductDetailInfo = ({product}) => {
    return (
        <div className={cls.productDetailInfo}>
            <img src={product.picture} alt={""} className={cls.productImage}></img>
            <div className={cls.productInfo}>
                <div className={cls.characteristics}>
                    <span className={cls.characteristicsTitle}>Пищевая ценность на 100 г</span>
                    <div className={cls.characteristicsValuesList}>
                        <div className={[cls.characteristicsValuesElemLeft, cls.characteristicsValuesElem].join(' ')}>
                            <span className={cls.nutritionalValue}>{product.calories}</span>
                            <span className={cls.nutritionalValueName}>ккал</span>
                        </div>
                        <div className={[cls.characteristicsValuesElemCenter, cls.characteristicsValuesElem].join(' ')}>
                            <span className={cls.nutritionalValue}>{product.proteins}</span>
                            <span className={cls.nutritionalValueName}>белки</span>
                        </div>
                        <div className={[cls.characteristicsValuesElemCenter, cls.characteristicsValuesElem].join(' ')}>
                            <span className={cls.nutritionalValue}>{product.fats}</span>
                            <span className={cls.nutritionalValueName}>жиры</span>
                        </div>
                        <div className={cls.characteristicsValuesElem}>
                            <span className={cls.nutritionalValue}>{product.carbohydrates}</span>
                            <span className={cls.nutritionalValueName}>углеводы</span>
                        </div>
                    </div>
                </div>
                <div className={cls.productDetailPrice}>
                    <div className={cls.priceList}>
                        <div className={cls.priceCurrent}>
                            <span>140</span>
                            <span className={cls.currentPriceCurrency}>₽</span>
                        </div>
                        { product.offer &&
                            <div className={cls.priceOld}>
                                <span>{product.offer.oldPrice} ₽</span>
                            </div>
                        }
                    </div>
                    <PrimaryButton>
                        <span>Добавить в корзину</span>
                    </PrimaryButton>
                </div>
            </div>
        </div>
    );
};

export default ProductDetailInfo;