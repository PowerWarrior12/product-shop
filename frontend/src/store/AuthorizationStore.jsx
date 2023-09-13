import AuthorizationRepository from "../repository/AuthorizationRepository";

export default class AuthorizationStore {
    isAuth= false;
    setAuth(isAuth) {
        this.isAuth = isAuth
    }
    async authorization(login, password) {
        try {
            const response = await AuthorizationRepository.authorization(login, password)
            localStorage.setItem('jwtToken', response.data)
            console.log("JWT TOKEN : " + response.data)
            this.setAuth(true)
        } catch (exception) {
            console.log(exception.message)
        }
    }
}