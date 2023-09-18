import React from 'react';
import cls from './ErrorBlock.module.css'
const ErrorBlock = ({children}) => {
    return (
        <div className={cls.errorContainer}>
            {children}
        </div>
    );
};

export default ErrorBlock;