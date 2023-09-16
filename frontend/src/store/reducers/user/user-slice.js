import {createSlice} from "@reduxjs/toolkit";

const initialState = {
    user: undefined,
}

export const userSlice = createSlice({
    name: "user",
    initialState: initialState,
    reducers: {
        setUser(state, action) {
            state.user = action.payload
        },
        logout(state) {
            state.user = undefined
        }
    }
})

export default userSlice.reducer
export const { setUser, logout} = userSlice.actions