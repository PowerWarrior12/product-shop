import axiosInstance from "../http/HttpInit";
export default class UserRepository {
    static async getUserInfo() {
        return axiosInstance.get("/user")
    }
}
