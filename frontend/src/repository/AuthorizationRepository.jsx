import axiosInstance from "../http/HttpInit";

export default class AuthorizationRepository {
    static async authorization(login, password) {
        return axiosInstance.post("/account/login", {login, password})
    }

    static async registration(userData) {
        return axiosInstance.post("/account/registration", userData)
    }
}