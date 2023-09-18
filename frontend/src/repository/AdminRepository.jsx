import axiosInstance from "../http/HttpInit";

export default class AdminRepository {
    static async addProduct(multipartForm) {
        return axiosInstance.post("/admin/products/add", multipartForm, {
            headers: {
                "Content-Type": "multipart/form-data"
            }
        })
    }
}