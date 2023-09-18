import {createAsyncThunk} from "@reduxjs/toolkit";
import AuthorizationRepository from "../../../repository/AuthorizationRepository";
import {fetchUserInfo} from "../user/user-thunks";
import {resetUser} from "../user/user-slice";

export const fetchLogin = createAsyncThunk(
    "auth/login",
    async ({loginData}, thunkApi) => {
        try {
            const response = await AuthorizationRepository.authorization(loginData.login, loginData.password)
            localStorage.setItem('jwtToken', response.data)
            thunkApi.dispatch(fetchUserInfo())
            return response.data
        } catch (exception) {
            return thunkApi.rejectWithValue(exception.response.data)
        }
    }
)

export const logout = createAsyncThunk(
    "auth/logout",
    async (_, thunkApi) => {
        localStorage.setItem('jwtToken', null)
        thunkApi.dispatch(resetUser())
    }
)