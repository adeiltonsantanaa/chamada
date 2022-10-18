import React from "react";
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import Login from "./Pages/Login";
import Chamadas from "./Pages/chamadas";
import NovaChamada from "./Pages/novaChamada";
import { isAuthenticated } from './auth'

const Private = ({Component}) => {
    return isAuthenticated() ? <Component/> : <Navigate to="/login"/>
};

export default function rotas() {
    return (
        <BrowserRouter>
            <Routes>
                <Route exact path="/login" element={<Login />} />
                <Route exact path="/chamadas" element={<Private Component={Chamadas}/>} />
                <Route exact path="/chamadas/manual" element={<Private Component={NovaChamada}/>} />
            </Routes>
        </BrowserRouter>
    );
}