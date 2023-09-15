import React from 'react';
import cls from "./PageHeader.module.css";

const PageHeader = ({children}) => {
    return (
        <div className={cls.productsHeader}>
            <div className="container-main">
                <div className={cls.headerInner}>
                    <div className={cls.header}>
                        {children}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default PageHeader;