import AuthorizationRepository from "../repository/AuthorizationRepository";

export default class AuthorizationStore {
    async authorization(login, password) {
        try {
            const response = await AuthorizationRepository.authorization(login, password)
            localStorage.setItem('jwtToken', response.data)
            localStorage.setItem('isAuth', true)
            return true
        } catch (exception) {
            console.log(exception.message)
            return false
        }
    }

    async logout() {
        localStorage.setItem('jwtToken', null)
        localStorage.setItem('isAuth', false)
    }
}