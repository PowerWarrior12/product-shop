import CustomModal from "../UI/modal/CustomModal";
import {Button, TextField} from "@mui/material";
import cls from "./AuthorizationModal.module.css"
import {useEffect, useState} from "react";
import {useDispatch, useSelector} from "react-redux";
import {fetchLogin} from "../../store/reducers/auth/auth-thunks"
import {selectErrorFromAuth, selectLoadingStateFromAuth} from "../../store/reducers/auth/auth-selector";
import {LoadingState} from "../../constants/LoadingState";
import {setAuthLoadingState} from "../../store/reducers/auth/auth-slice";
import ErrorBlock from "../errorBlock/ErrorBlock";

const AuthorizationModal = ({visible, setVisible}) => {
    const dispatch = useDispatch();
    const authState = useSelector(selectLoadingStateFromAuth);
    const authError = useSelector(selectErrorFromAuth)
    const [login, setLogin] = useState("");
    const [password, setPassword] = useState("");
    const authorization = () => {
        dispatch(fetchLogin({loginData: {login: login, password: password}}))
    }

    useEffect(() => {
        if (authState === LoadingState.SUCCESS) {
            setVisible(false)
            dispatch(setAuthLoadingState(LoadingState.NOT))
        }
    }, [authState])

    return (
        <CustomModal style={{width: "1000px"}} visible={visible} setVisible={setVisible}>
            <div className={cls.authForm}>
                <h2>Введите данные:</h2>
                <TextField value={login} onChange={e => setLogin(e.target.value)} id="outlined-basic" label="Е-mail"
                           variant="outlined"/>
                <TextField value={password} onChange={e => setPassword(e.target.value)} id="outlined-basic"
                           label="Пароль" variant="outlined"/>
                { authError &&
                    <ErrorBlock>
                        <h1>{authError}</h1>
                    </ErrorBlock>
                }
                <Button onClick={() => authorization()} variant="contained">Войти</Button>
            </div>
        </CustomModal>
    );
};

export default AuthorizationModal;