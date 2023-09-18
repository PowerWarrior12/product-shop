import React, {useState} from 'react';
import IconButton from "../UI/iconButton/IconButton";
import basketIcon from "../../icons/basket.svg"
import humanIcon from "../../icons/human.svg"
import ordersIcon from "../../icons/orders.svg"
import logoIcon from "../../icons/logo.png"
import cls from "./NavBar.module.css"
import AuthorizationModal from "../authorizationModal/AuthorizationModal";
import {useSelector} from "react-redux";
import {selectUserFromUserState} from "../../store/reducers/user/user-selector";
import {useNavigate} from "react-router-dom";

const NavBar = () => {
    const [authVisible, setAuthVisible] = useState(false)
    const user = useSelector(selectUserFromUserState)
    const router = useNavigate()

    const processAccountButtonClick = () => {
        user
            ? router("/account/personal")
            : setAuthVisible(true)
    }

    const processOrdersButtonClick = () => {
        user
            ? router("/account/orders")
            : setAuthVisible(true)
    }

    const processBasketButtonClick = () => {
        user
            ? router("/basket")
            : setAuthVisible(true)
    }

    const processLogoClick = () => {
        router("/")
    }

    return (
        <div className={cls.navBar}>
            <AuthorizationModal visible={authVisible} setVisible={setAuthVisible}/>
            <IconButton onClick={() => processBasketButtonClick()} image={basketIcon} title={"Корзина"}/>
            <IconButton onClick={() => processOrdersButtonClick()} image={ordersIcon} title={"Заказы"}/>
            <IconButton onClick={() => processAccountButtonClick()} image={humanIcon} title={ user ? user.first_name : "Войти" }/>
            <div onClick={() => processLogoClick()} className={cls.logoContainer}>
                <img src={logoIcon} alt={"logo"} className={cls.logo}/>
            </div>
        </div>
    );
};

export default NavBar;