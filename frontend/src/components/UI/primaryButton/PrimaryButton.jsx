import React from 'react';
import cls from './PrimaryButton.module.css'

const PrimaryButton = ({children, ...props}) => {
    return (
        <div className={cls.basket}>
            <button {...props} className={[cls.primaryButton, cls.buttonTypeOutline].join(' ')}>
                <div className={cls.primaryButtonInner}>
                    {children}
                </div>
            </button>
        </div>
    );
};

export default PrimaryButton;