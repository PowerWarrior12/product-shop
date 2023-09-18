import cls from './AccountPage.module.css'
import PersonalData from "./personalData/PersonalData";
import MenuTabs from "../../components/menuTabs/MenuTabs";
import {accountMenuItems, adminMenuItems} from "../../constants/commonConstants";
import {useDispatch, useSelector} from "react-redux";
import {selectUserFromUserState} from "../../store/reducers/user/user-selector";
import {logout} from "../../store/reducers/auth/auth-thunks";
import {useNavigate} from "react-router-dom";
import {AppRouter} from "../../components/AppRouter";
import {accountRouters} from "../../router/routers";
import {useEffect, useState} from "react";
import {Roles} from "../../constants/Roles";

const AccountPage = () => {
    const router = useNavigate()
    const dispatch = useDispatch()
    const user = useSelector(selectUserFromUserState)
    const [isAdmin, setIsAdmin] = useState(false)

    useEffect(() => {
        if (user) {
            setIsAdmin(user.roles.includes(Roles.ADMIN));
        }
    }, [user]);

    const prepareMenuClick = (value) => {
        if (value === "logout") {
            dispatch(logout())
            router("/")
        } else {
            router(`/account/${value}`)
        }
    }

    return (
        <div>
            {user
                ?
                <div className="container-main">
                    <div className={cls.accountContainer}>
                        <MenuTabs onChange={prepareMenuClick}
                                  menuItems={ isAdmin ? adminMenuItems : accountMenuItems }
                        />
                        <div className={cls.tabsContainer}>
                            <AppRouter routers={accountRouters}/>
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
