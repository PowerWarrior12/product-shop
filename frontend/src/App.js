import './App.css';
import {BrowserRouter} from "react-router-dom";
import {AppRouter} from "./components/AppRouter";
import NavBar from "./components/navBar/NavBar";
import React, {useEffect} from "react";
import {useDispatch} from "react-redux";
import {fetchUserInfo} from "./store/reducers/user/user-thunks";
import {routers} from "./router/routers";
import {setBasketProducts} from "./store/reducers/basket/basket-slice";

function App() {

    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(fetchUserInfo())
        if (localStorage.getItem("basket")) {
            dispatch(setBasketProducts(JSON.parse(localStorage.getItem("basket"))))
        }
    }, []);

    return (
        <BrowserRouter>
            <div className="App">
                <div>
                    <div className="container-main">
                        <NavBar/>
                    </div>
                    <AppRouter routers={routers}/>
                </div>
            </div>
        </BrowserRouter>
    );
}

export default App;
