import {createSlice} from "@reduxjs/toolkit";

const initialState = {
    login: "",
    isRegistered: false,
    isLoading: false,
    success: "",
    error: ""
}

export const authSlice = createSlice({
    name: "auth",
    initialState: initialState,
    reducers: {
        setAuthLoadingState(state, action) {
            state.isLoading = action.payload
        },
        resetAuthState : () => initialState
    }
})

export default authSlice.reducer
export const { setAuthLoadingState, resetAuthState} = authSlice.actions