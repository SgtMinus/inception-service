import React, {useState} from 'react';

export default function DreamOrderElement({order, setModalActive, setOrder}) {

    return (
            <div className="card" style={{"flex":"0 0 33.333333%"}}>
                <div className="card-body">
                    <h5 className="card-title">{order.dreamOrderName}</h5>
                    <p className="card-text">{order.dreamOrderDescription}</p>
                    <button className="btn btn-primary"  onClick={
                        () => {
                            setModalActive(true)
                            setOrder(order)
                        }
                    }>show more info</button>
                </div>
            </div>
    )

}