import {useNavigate} from "react-router-dom";
import React from "react";


export default function AddNewArchitector() {
    const nav = useNavigate()

    const onArchitectAdd = () => {
        nav("/profile")
    }

    return (
        <div className="container-fluid d-flex h-100 justify-content-center align-items-center p-0">
            <div className="row bg-white shadow-sm">
                <div className="col border rounded p-4">
                    <form  onSubmit={() => onArchitectAdd()}>
                        <h3 className="text-center mb-4">Add new architect</h3>
                        <div className="form-group ">
                            <label>Name</label>
                            <input type="text" className="form-control" name='name' placeholder="description"/>
                        </div>

                        <div className="form-group ">
                            <label>Surname</label>
                            <input type="text" className="form-control" name='surname' placeholder="date"/>
                        </div>

                        <div className="form-group">
                            <label>City</label>
                            <input type="text" className="form-control" name='city' placeholder="participant"/>
                        </div>

                        <div className="form-group">
                            <label>Age</label>
                            <input type="text" className="form-control" name='age' placeholder="participant"/>
                        </div>

                        <button type="submit" className="btn btn-primary w-100" >Submit</button>
                    </form>
                </div>
            </div>
        </div>
    )
}