import './App.css';
import {BrowserRouter} from "react-router-dom";
import {AppRouter} from "./components/AppRouter";
import NavBar from "./components/navBar/NavBar";
import React from "react";
import {AuthContext} from "./context/AuthContext";
import AuthorizationStore from "./store/AuthorizationStore";

function App() {
    const authStore = new AuthorizationStore()
    return (
        <AuthContext.Provider value={{authStore}}>
            <div className="App">
                <div>
                    <div className="container-main">
                        <NavBar/>
                    </div>
                    <BrowserRouter>
                        <AppRouter/>
                    </BrowserRouter>
                </div>
            </div>
        </AuthContext.Provider>
    );
}

export default App;
