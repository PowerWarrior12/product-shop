import {combineReducers} from "redux";
import {configureStore} from "@reduxjs/toolkit";
import authReducer from "./reducers/auth/auth-slice"
import userReducer from "./reducers/user/user-slice"

const rootReducer = combineReducers({
    auth: authReducer,
    user: userReducer
})

export const setupStore = () => {
    return configureStore({
        reducer: rootReducer
    })
}