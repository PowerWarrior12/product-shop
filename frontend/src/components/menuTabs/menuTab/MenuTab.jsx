import React from 'react';
import cls from './MenuTab.module.css'

const MenuTab = ({menuItem, onClick}) => {
    return (
        <div className={cls.menuTabContainer} onClick={() => onClick(menuItem.value)}>
            <img className={cls.icon} src={menuItem.image} alt={""}/>
            <span>{menuItem.title}</span>
        </div>
    );
};

export default MenuTab;