import {createSlice} from "@reduxjs/toolkit";
import {fetchUserInfo} from "./user-thunks";

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
        resetUser(state) {
            state.user = undefined
        }
    },
    extraReducers(builder) {
        builder.addCase(fetchUserInfo.fulfilled, (state, action) => {
            state.user = action.payload
        });
    }
})

export default userSlice.reducer
export const { setUser, resetUser} = userSlice.actions