import React, {useState} from "react";

export default function DreamOrderPage({active, setActive, dreamOrder}) {
    const [_, update] = useState(true)

    if (active === false) {
        return null
    }

    const modalStyle = {
        backgroundColor: '#FFF',
        borderRadius: 5,
        maxWidth: 500,
        minHeight: 300,
        margin: '0 auto',
        padding: 30
    };

    const backdropStyle = {
        position: 'fixed',
        top: 0,
        bottom: 0,
        left: 0,
        right: 0,
        backgroundColor: 'rgba(0,0,0,0.3)',
        padding: 50
    };

    const closeModal = () => {
        setActive(false)
        update(false)
    }

    return (
        <div className="backdrop" style={backdropStyle}>
            <div style={modalStyle}>
                <h1>{dreamOrder.dreamOrderName}</h1>
                <h1>{dreamOrder.dreamOrderDescription}</h1>
                <h1>{dreamOrder.dreamUUID}</h1>
                <button className="btn btn-primary" onClick={closeModal}>
                    Close
                </button>
            </div>
        </div>
    );
}