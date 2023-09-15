import cls from './CheckBoxControl.module.css';
import checkBoxImage from "../../../../icons/checkbox.svg";

const CheckBoxControl = ({state}) => {
    return (
        <span
            className={state ? [cls.checkBoxControl, cls.checkBoxControlChecked].join(' ') : cls.checkBoxControl}>
            { state
                ? <img src={checkBoxImage} alt={""}/>
                : <div></div>
            }
        </span>
    );
};

export default CheckBoxControl;