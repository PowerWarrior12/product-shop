import React, {useState} from 'react';
import cls from './PersonalData.module.css'
import {Button, TextField} from "@mui/material";
const PersonalDataTab = () => {

    const [login, setLogin] = useState("businessmail1710@mail.ru")
    const [name, setName] = useState("Пётр")
    const [lastName, setLastName] = useState("Юхлимов")

    const changePersonalData = () => {

    }

    return (
        <div className={cls.mainContainer}>
            <h1 className={cls.personalDataTitle}>Личные данные</h1>
            <TextField className={[cls.personalDataTab].join(' ')} value={login} onChange={e => setLogin(e.target.value)} id="outlined-basic" label="Е-mail" variant="outlined" />
            <TextField className={[cls.personalDataTab].join(' ')}  value={name} onChange={e => setName(e.target.value)} id="outlined-basic" label="Имя" variant="outlined" />
            <TextField className={[cls.personalDataTab].join(' ')}  value={lastName} onChange={e => setLastName(e.target.value)} id="outlined-basic" label="Фамилия" variant="outlined" />
            <Button className={[cls.personalDataTab, cls.submitButton].join(' ')}  onClick={() => changePersonalData()} variant="contained">Сохранить</Button>
        </div>
    );
};

export default PersonalDataTab;