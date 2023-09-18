import React from 'react';
import cls from './PaginationMoreBlock.module.css'

const PaginationMoreBlock = ({onClick}) => {
    return (
        <div onClick={onClick} className={cls.paginationMoreBlock}>
            <span className={cls.paginationMoreBlock__content}>Показать ещё</span>
        </div>
    );
};

export default PaginationMoreBlock;