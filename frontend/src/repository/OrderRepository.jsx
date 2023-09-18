import axiosInstance from "../http/HttpInit";

export class OrderRepository {
    static async getOrders() {
        return axiosInstance.get("/orders/my")
    }

    static async createOrder(order) {
        return axiosInstance.post("/orders/add", order)
    }
}