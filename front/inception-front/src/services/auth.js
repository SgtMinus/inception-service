import axios from 'axios';
import tokenService from "./token";


const authClient = axios.create({
    baseURL: 'http://localhost:8080',
});

const login = (data) => {
    return authClient.post("/sign-in", data)
        .then(resp => {
            console.log(resp.data)
            tokenService.setToken(resp.data.token)
        })
}

const register = (data) => {
    return authClient.post('/sign-up', data)
        .then(resp => {
            console.log(resp.data)
            localStorage.setItem("token", resp.token)
        })
}

const authService = {
    login,
    register,
};

export default authService;