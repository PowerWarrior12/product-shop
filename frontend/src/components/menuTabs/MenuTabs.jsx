import React from 'react';
import cls from './MenuTabs.module.css'
import MenuTab from "./menuTab/MenuTab";

const MenuTabs = ({menuItems, onChange}) => {
    return (
        <div className={cls.menuContainer}>
            { menuItems.map(menuItem =>
                <div className={cls.itemContainer}>
                    <div/>
                    <MenuTab menuItem={menuItem} onClick={onChange}/>
                </div>
            )}
        </div>
    );
};

export default MenuTabs;