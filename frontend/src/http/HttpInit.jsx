import axios from "axios";

export const API_URL = "http://localhost:8080";

const axiosInstance = axios.create({
    baseURL: API_URL,
    withCredentials: true
})

axiosInstance.interceptors.request.use( config => {
        let token = localStorage.getItem('jwtToken')
        if (token !== "undefined") {
            config.headers.Authorization = token
        }
        return config
}, error => {
    console.log(error)
    Promise.reject(error)
})

export default axiosInstance;