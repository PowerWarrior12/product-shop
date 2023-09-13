import axiosInstance from "../http/HttpInit";

export default class ProductRepository {
    static async load(filter) {
        return axiosInstance.post("/products/custom-filter", filter)
    }

    static async loadFilters(filters) {
        return axiosInstance.post("/filters", filters)
    }
}