import React from "react";
import {Link} from 'react-router-dom';
import { FiArrowLeft } from "react-icons/fi";

import './styles.css';

export default function NovaChamada(){
    return (
        <div className="new-chamada-container">
            <div className="content">
                <section className="form">
                    <h1>Adicionar Nova Chamada</h1>
                    <Link className="back-link" to='/chamadas'>
                        <FiArrowLeft size={16} color='#251fc5'/>
                        Chamadas
                    </Link>
                </section>
                <div>
                <p className="paragrafo">Entre com a informação da chamada</p>
                <form>
                    <input placeholder="Matricula"/>
                    <input placeholder="Disciplina"/>
                    <button className="button" type="submit">Add</button>
                </form>
                </div>
            </div>
        </div>
    );
}