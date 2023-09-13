import React, {useState} from 'react';
import cls from './CheckBox.module.css'
import CheckBoxControl from "./checkBoxControl/CheckBoxControl";

const CheckBox = ({onClick, title, startState}) => {
    const [state, setState] = useState(startState)
    return (
        <div className={cls.checkBoxContainer} onClick={() => {
            onClick(!state, title)
            setState(!state)
        }}>
            <CheckBoxControl state={state}/>
            <span className={cls.checkBoxTitle}>{title}</span>
        </div>
    );
};

export default CheckBox;