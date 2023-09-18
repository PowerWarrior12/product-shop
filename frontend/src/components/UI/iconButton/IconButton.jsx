import React from 'react';
import cls from './IconButton.module.css'

const IconButton = ({image, title, onClick}) => {
    return (
        <div className={cls.iconButtonContainer} onClick={onClick}>
            <img src={image} alt={title} className={cls.image}/>
            <div className={cls.title}>{title}</div>
        </div>
    );
};

export default IconButton;