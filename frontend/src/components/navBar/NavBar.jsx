import React, {useState} from 'react';
import IconButton from "../UI/iconButton/IconButton";
import basketIcon from "../../icons/basket.svg"
import humanIcon from "../../icons/human.svg"
import ordersIcon from "../../icons/orders.svg"
import logoIcon from "../../icons/logo.png"
import cls from "./NavBar.module.css"
import AuthorizationModal from "../authorizationModal/AuthorizationModal";

const NavBar = () => {
    const [authVisible, setAuthVisible] = useState(false)
    /*let openAuth = () => {}

    const initAuthModal = (callback) => {
        openAuth = callback
    }
*/
    return (
        <div className={cls.navBar}>
            <AuthorizationModal visible={authVisible} setVisible={setAuthVisible}/>
            <IconButton image={basketIcon} title={"Корзина"}/>
            <IconButton image={ordersIcon} title={"Заказы"}/>
            <IconButton onClick={() => setAuthVisible(true)} image={humanIcon} title={"Войти"}/>
            <div className={cls.logoContainer}>
                <img src={logoIcon} alt={"logo"} className={cls.logo}/>
            </div>
        </div>
    );
};

export default NavBar;