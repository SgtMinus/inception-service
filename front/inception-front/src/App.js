import "./styles.css"
import Login from "./components/auth/loginForm"
import Register from "./components/auth/registerForm"
import {BrowserRouter as Router, Link, Route, Routes} from "react-router-dom";
import MainPage from "./pages/mainPage";
import DreamOrderList from "./pages/dreamOrdersPage";
import DreamOrderPage from "./pages/dreamOrderPage";
import CreateNewDreamOrder from "./pages/createNewDreamOrder";
import AddNewArchitector from "./pages/addNewArchitector";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Login/>}/>
                <Route path="/sign-in" element={<Login/>}/>
                <Route path="/sign-up" element={<Register/>}/>
                <Route path="/home" element={<DreamOrderList/>}/>
                <Route path="/new-architect" element={<AddNewArchitector/>}/>
                <Route path={"/create-dream-order" } element={<CreateNewDreamOrder/>}/>
            </Routes>
        </Router>
    );
}

export default App;
