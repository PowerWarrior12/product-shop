import React from 'react';
import cls from './FilterBoxes.module.css'
import FilterList from "./filterList/FilterList";

const FilterBoxes = ({filterBoxes, selectedFilters, setSelectedFilters}) => {
    const changeSelectedFilterBoxes = (changeableFilterBox) => {
        let newSelectedFilterBoxes = ([...(selectedFilters.filter((item) => item.filter_type !== changeableFilterBox.filter_type))])

        if (changeableFilterBox.values.length !== 0) {
            newSelectedFilterBoxes.push(changeableFilterBox)
        }
        setSelectedFilters(newSelectedFilterBoxes)
    }
    return (
        <div className={cls.filterBoxes}>
            {filterBoxes.map(filterBox => {
                const selectedFilter = selectedFilters.find(item => item.filter_type === filterBox.filter_type)
                const selectedFilterValues = selectedFilter ? selectedFilter.values : []
                return <FilterList key={filterBox.filter_type} filterBox={filterBox}
                            onChange={changeSelectedFilterBoxes}
                            selectedFilters={selectedFilterValues}>
                        </FilterList>
            })}
        </div>);
};

export default FilterBoxes;