import CustomModal from "../UI/modal/CustomModal";
import {Button, TextField} from "@mui/material";
import cls from "./AuthorizationModal.module.css"
import {useContext, useState} from "react";
import {AuthContext} from "../../context/AuthContext";

const AuthorizationModal = ({visible, setVisible}) => {
    const {authStore} = useContext(AuthContext);
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");
    const authorization = () => {
        authStore.authorization(login, password);
    }

    return (
        <CustomModal style={{width: "1000px"}} visible={visible} setVisible={setVisible}>
            <div className={cls.authForm}>
                <h2>Введите данные:</h2>
                <TextField value={login} onChange={e => setLogin(e.target.value)} id="outlined-basic" label="Е-mail" variant="outlined" />
                <TextField value={password} onChange={e => setPassword(e.target.value)} id="outlined-basic" label="Пароль" variant="outlined" />
                <Button onClick={() => authorization()} variant="contained">Войти</Button>
            </div>
        </CustomModal>
    );
};

export default AuthorizationModal;