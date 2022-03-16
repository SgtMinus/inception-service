import React from 'react';
import authService from "../../services/auth";
import { useNavigate } from 'react-router-dom';
// import './styles/auth.css'

export default function Login() {
    const navigate = useNavigate();

    const startLogin = event => {
        event.preventDefault()
        let formData = new FormData(event.target)
        const data = {
            "email": formData.get("email"),
            "password": formData.get("password")
        }
        console.log(data)
        navigate("/home")
        // authService.login(data).then(resp => {
        //     console.log("fetched!")
        //
        // })
    }

    return (
        <div className="container-fluid d-flex h-100 justify-content-center align-items-center p-0">
            <div className="row bg-white shadow-sm">
                <div className="col border rounded p-4">
                    <form onSubmit={startLogin}>
                        <h3 className="text-center mb-4">Login</h3>
                        <div className="form-group ">
                            <label>Email</label>
                            <input type="email" className="form-control" name='email' placeholder="Enter email"/>
                        </div>

                        <div className="form-group">
                            <label>Password</label>
                            <input type="password" className="form-control" name="password" placeholder="Enter password"/>
                        </div>

                        <button type="submit" className="btn btn-primary w-100" >Sign in</button>
                    </form>
                </div>
            </div>
        </div>
    );
}