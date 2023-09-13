import React from 'react';
import cls from './FilterList.module.css'
import CheckBox from "../../UI/checkBox/CheckBox";

const FilterList = ({onChange, filterBox, selectedFilters}) => {
    const changeSelectedFilterBox = (state, title) => {
        let newSelectedFilters;
        if (state) {
            newSelectedFilters = [...selectedFilters, title]
        } else {
            newSelectedFilters = selectedFilters.filter(item => item.name !== title)
        }
        onChange({
            filter_type: filterBox.filter_type,
            values: newSelectedFilters.map(
                filter => {
                    return {
                        name: filter
                    }
                }
            )
        })
    }
    return (
        <div className={cls.filtersContainer}>
            <div className={cls.filterBoxTitleContainer}>
                <h5 className={cls.filterBoxTitle}>{filterBox.filter_type}</h5>
            </div>
            {
                filterBox.values.map(filter =>
                    <div key={filter.name} className={cls.filterRow}>
                        <CheckBox onClick={changeSelectedFilterBox} title={filter.name} startState={filter.checked}/>
                        <div className={cls.filterCount}>30</div>
                    </div>
                )
            }
        </div>
    );
};

export default FilterList;