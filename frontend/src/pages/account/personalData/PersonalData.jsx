import React, {useState} from 'react';
import cls from './PersonalData.module.css'
import {Button, TextField} from "@mui/material";
import {useSelector} from "react-redux";
import {selectUserFromUserState} from "../../../store/reducers/user/user-selector";
const PersonalData = () => {

    const user = useSelector(selectUserFromUserState)
    const [login, setLogin] = useState(user.login)
    const [name, setName] = useState(user.first_name)
    const [lastName, setLastName] = useState(user.last_name)
    const [phoneNumber, setPhoneNumber] = useState(user.phone_number)

    const changePersonalData = () => {

    }

    return (
        <div className={cls.mainContainer}>
            <h1 className={cls.personalDataTitle}>Личные данные</h1>
            <div className={[cls.personalDataTab].join(' ')}>
                <TextField value={login} onChange={e => setLogin(e.target.value)} id="outlined-basic" label="Е-mail" variant="outlined" />
            </div>
            <div className={[cls.personalDataTab].join(' ')}>
                <TextField value={name} onChange={e => setName(e.target.value)} id="outlined-basic" label="Имя" variant="outlined" />
            </div>
            <div className={[cls.personalDataTab].join(' ')}  >
                <TextField value={lastName} onChange={e => setLastName(e.target.value)} id="outlined-basic" label="Фамилия" variant="outlined" />
            </div>
            <div className={[cls.personalDataTab].join(' ')}  >
                <TextField value={phoneNumber} onChange={e => setPhoneNumber(e.target.value)} id="outlined-basic" label="Телефон" variant="outlined" />
            </div>
            <div className={[cls.personalDataTab, cls.submitButton].join(' ')}>
                <Button onClick={() => changePersonalData()} variant="contained">Сохранить</Button>
            </div>
        </div>
    );
};

export default PersonalData;