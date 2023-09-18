import {createSlice} from "@reduxjs/toolkit";
import {LoadingState} from "../../../constants/LoadingState";
import {fetchLogin} from "./auth-thunks";

const initialState = {
    login: "",
    isRegistered: false,
    loadingState: LoadingState.NOT,
    success: "",
    error: undefined
}

export const authSlice = createSlice({
    name: "auth",
    initialState: initialState,
    reducers: {
        setAuthLoadingState(state, action) {
            state.isLoading = action.payload
        },
        resetAuthState : () => initialState
    },
    extraReducers(builder) {
        builder.addCase(fetchLogin.pending, (state) => {
           state.loadingState = LoadingState.LOADING;
           state.error = undefined
        });
        builder.addCase(fetchLogin.rejected, (state, action) => {
            state.loadingState = LoadingState.ERROR
            state.error = action.payload
        });
        builder.addCase(fetchLogin.fulfilled, (state) => {
            state.loadingState = LoadingState.SUCCESS
        })

    }
})

export default authSlice.reducer
export const { setAuthLoadingState, resetAuthState} = authSlice.actions