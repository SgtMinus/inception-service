import React from "react";
import { useNavigate } from 'react-router-dom';

export default function CreateNewDreamOrder() {
    const nav = useNavigate()

    const onDreamOrderCreate = () => {
        nav("/home")
    }

    return (
        <div className="container-fluid d-flex h-100 justify-content-center align-items-center p-0">
            <div className="row bg-white shadow-sm">
                <div className="col border rounded p-4">
                    <form  onSubmit={() => onDreamOrderCreate()}>
                        <h3 className="text-center mb-4">Create new dream order</h3>
                        <div className="form-group ">
                            <label>Description</label>
                            <input type="text" className="form-control" name='description' placeholder="description"/>
                        </div>

                        <div className="form-group ">
                            <label>Due date</label>
                            <input type="text" className="form-control" name='date' placeholder="date"/>
                        </div>

                        <div className="form-group">
                            <label>Participant id</label>
                            <input type="text" className="form-control" name='participant' placeholder="participant"/>
                        </div>

                        <button type="submit" className="btn btn-primary w-100" >Submit</button>
                    </form>
                </div>
            </div>
        </div>
    )
}