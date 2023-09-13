import React, {useState} from 'react';
import cls from './SortingComponent.module.css'

const SortingComponent = ({sorts, currentSort, setCurrentSort}) => {
    const changeSelected = (value) => {
        let newSelected = null
        if (value !== currentSort) {
            newSelected = value
        }
        setCurrentSort(newSelected)
    }
    return (
        <div className={cls.sortsContainer}>
            Сортировать:
            {
                sorts.map(sort =>
                    <div
                        key={sort.value}
                        onClick={() => changeSelected(sort.value)}
                        className={(currentSort === sort.value) ? [cls.sortsItem, cls.sortsItemSelected].join(' ') : cls.sortsItem}>
                        {sort.title}
                    </div>
                )
            }
        </div>
    );
};

export default SortingComponent;