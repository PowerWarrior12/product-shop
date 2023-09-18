import React from 'react';
import cls from "../secondaryButton/SecondaryButton.module.css";

const SecondaryButton = ({children, ...props}) => {
    return (
        <div className={cls.basket}>
            <button {...props} className={[cls.secondaryButton, cls.buttonTypeSolid].join(' ')}>
                <div className={cls.secondaryButtonInner}>
                    {children}
                </div>
            </button>
        </div>
    );
};

export default SecondaryButton;