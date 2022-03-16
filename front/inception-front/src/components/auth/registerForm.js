import React from 'react';
import authService from "../../services/auth";
import { useNavigate } from 'react-router-dom';

export default function Register() {
    const navigate = useNavigate();
    const startRegister = event => {
        event.preventDefault()
        let formData = new FormData(event.target)
        const data = {
            "email": formData.get("email"),
            "name": formData.get("name"),
            "surname": formData.get("surname"),
            "password": formData.get("password")
        }
        console.log(data)
        navigate("/home")
        // authService.register(data).then( resp => {
        //     console.log("fetched!")
        //     navigate("/home")
        // })
    }

    return (
        <div className="container-fluid d-flex h-100 justify-content-center align-items-center p-0">
            <div className="row bg-white shadow-sm">
                <div className="col border rounded p-4">
                    <form onSubmit={startRegister}>
                        <h3 className="text-center mb-4">Register</h3>
                        <div className="form-group ">
                            <label>Email</label>
                            <input type="email" name="email" className="form-control" placeholder="Enter email"/>
                        </div>

                        <div className="form-group ">
                            <label>Name</label>
                            <input type="text" name="name" className="form-control" placeholder="Enter name"/>
                        </div>

                        <div className="form-group ">
                            <label>Surname</label>
                            <input type="text" name="password" className="form-control" placeholder="Enter surname"/>
                        </div>

                        <div className="form-group">
                            <label>Password</label>
                            <input type="password" name="password" className="form-control "
                                   placeholder="Enter password"/>
                        </div>

                        <button type="submit" className="btn btn-primary w-100 ">Sign up</button>
                    </form>
                </div>
            </div>
        </div>
    )
}