import React from "react";
import { BrowserRouter, Route, Routes, Navigate } from "react-router-dom";
import { isAuthenticated } from './auth'

import Login from "./Pages/Login";
import Chamadas from "./Pages/chamadas";
import NovaChamada from "./Pages/novaChamada";
import RegistroChamadaAluno from "./Pages/regChamada";
import Error404 from "./Pages/404";
import RegistroAula from "./Pages/registroDeAula";

const Private = ({Component}) => {
    return isAuthenticated() ? <Component/> : <Navigate to="/login"/>
};

export default function rotas() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="*" element={<Error404 />} />
                <Route exact path="/login" element={<Login />} />
                <Route exact path="/chamadas" element={<Private Component={Chamadas}/>} />
                <Route exact path="/chamadas/manual" element={<Private Component={NovaChamada}/>} />
                <Route exact path="/chamadas/registrar/aula" element={<Private Component={RegistroAula}/>} />
                <Route exact path="/" element={<RegistroChamadaAluno/>}/>
            </Routes>
        </BrowserRouter>
    );
}