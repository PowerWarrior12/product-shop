import React from 'react';
import cls from './AddDeleteButton.module.css'
import plus from '../../../icons/plus--white.svg'
import minus from '../../../icons/minus--white.svg'

const AddDeleteButton = ({onPlusClick, onMinusClick, count}) => {
    return (
        <div className={cls.basket}>
            <div className={[cls.buttonSolid, cls.addDeleteButton].join(' ')}>
                <div onClick={onMinusClick} className={cls.buttonContainer}>
                    <img src={minus} className={cls.buttonImage} alt=""/>
                </div>
                <div className={cls.countContainer}>
                    <div className={cls.countText}>
                        {count} шт
                    </div>
                </div>
                <div onClick={onPlusClick} className={cls.buttonContainer}>
                    <img src={plus} className={cls.buttonImage} alt=""/>
                </div>
            </div>
        </div>
    );
};

export default AddDeleteButton;