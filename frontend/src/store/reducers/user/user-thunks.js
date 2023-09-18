import {createAsyncThunk} from "@reduxjs/toolkit";
import UserRepository from "../../../repository/UserRepository";

export const fetchUserInfo = createAsyncThunk(
    "user/fetchUserInfo",
    async () => {
        const response = await UserRepository.getUserInfo()
        return response.data
    }
)