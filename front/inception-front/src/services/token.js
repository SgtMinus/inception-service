import Cookies from 'js-cookie';

const tokenKey = 'authorisation';

const setToken = (token) => {
    localStorage.setItem(tokenKey, token)
};

const getToken = () => {
    return  localStorage.getItem(tokenKey)
};

const tokenService = {
    setToken,
    getToken,
};

export default tokenService;