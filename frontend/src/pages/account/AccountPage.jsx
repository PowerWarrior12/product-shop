import React, {useContext} from 'react';
import cls from './AccountPage.module.css'
import PersonalDataTab from "./personalData/PersonalDataTab";
import MenuTabs from "../../components/menuTabs/MenuTabs";
import {accountMenuItems} from "../../constants/commonConstants";
import {AuthContext} from "../../context/AuthContext";
import {useDispatch, useSelector} from "react-redux";
import {selectUserFromUserState} from "../../store/reducers/user/user-selector";
import {logout} from "../../store/reducers/user/user-slice";

const AccountPage = () => {
    const {authStore} = useContext(AuthContext);
    const dispatch = useDispatch()
    const user = useSelector(selectUserFromUserState)
    const prepareMenuClick = (value) => {
        if (value === "logout") {
            authStore.logout().then(() => {
                dispatch(logout())
            });
        }
    }

    return (
        <div>
            {user
                ?
                <div className="container-main">
                    <div className={cls.accountContainer}>
                        <MenuTabs onChange={prepareMenuClick} menuItems={accountMenuItems}/>
                        <div className={cls.tabsContainer}>
                            <PersonalDataTab/>
                        </div>
                    </div>
                </div>
                :
                <h1>Лох, авторизуйся</h1>
            }
        </div>
    );
};

export default AccountPage;
