import {combineReducers} from "redux";
import {configureStore} from "@reduxjs/toolkit";
import authReducer from "./reducers/auth/auth-slice"
import userReducer from "./reducers/user/user-slice"
import basketReducer from "./reducers/basket/basket-slice"
import {enableMapSet} from "immer";

const rootReducer = combineReducers({
    auth: authReducer,
    user: userReducer,
    basket: basketReducer
})

export const setupStore = () => {

    enableMapSet();

    return configureStore({
        reducer: rootReducer,
        middleware: (getDefaultMiddleware) => getDefaultMiddleware({
            serializableCheck: false
        }),
    })
}