import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";

import Login from "./Pages/Login";
import Book from "./Pages/Book";
import NewBook from "./Pages/NewBook";

export default function Rotas() {
    return(
        <BrowserRouter>
            <Routes>
                <Route exact path="/" element={<Login/>}/>
                <Route exact path="/book" element={<Book/>}/>
                <Route exact path="/book/new" element={<NewBook/>}/>
            </Routes>
        </BrowserRouter>

    );
}