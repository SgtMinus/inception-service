import DreamOrderElement from "../components/dream/dreamOrderElement";
import { v4 as uuidv4 } from 'uuid';
import DreamOrderPage from "./dreamOrderPage";
import React, {useState} from "react";


export default function DreamOrderList() {
    let dreamOrders = []
    for (let i = 0; i < 12; i++) {
        dreamOrders[i] =
            {
                "dreamOrderName": "Dream " + i,
                "dreamOrderDescription": Date.now(),
                "dreamUUID": uuidv4()
            }
    }
    const [modalState, setModalActive] = useState(false)
    const [dreamOrdersData, setDreamOrders] = useState(null)


    return (
        <div style={{"display": "flex", "flex-wrap": "wrap", "padding-left": "0"}}>
            {dreamOrders.map(order => <DreamOrderElement order={order} setModalActive={setModalActive} setOrder={setDreamOrders} />)}
            <DreamOrderPage active={modalState} setActive={setModalActive} dreamOrder={dreamOrdersData}/>
        </div>)
}

