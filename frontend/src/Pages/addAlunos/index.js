import React, { useState } from "react";
import { Link } from 'react-router-dom';
import { FiArrowLeft } from "react-icons/fi";
import api from "../../services/api";
import './styles.css'

export default function AdicionarAlunos() {

    const [matricula, setMatricula] = useState();
    const [nome, setNome] = useState('');

    function salvaChamada() {
        const token = localStorage.getItem('accessToken');
        api.post('/api/v1/aluno', {
                matricula: matricula,
                nome: nome
        }, { headers: { Authorization: 'Bearer ' + token } }).then(res => alert("Aluno Registrado!"))
        .catch(err => alert(err.response.data.message))
    }

    return (
        <div className="new-chamada-container">
            <div className="content">
                <section className="form">
                    <h1>Adicionar Novo Aluno</h1>
                    <Link className="back-link" to='/chamadas'>
                        <FiArrowLeft size={16} color='#251fc5' />
                        Chamadas
                    </Link>
                </section>
                <div>
                    <p className="paragrafo">Entre com a informação do aluno</p>
                    <form>
                        <input
                            placeholder="Matricula"
                            onChange={e => setMatricula(e.target.value)}
                        />
                        <input
                            placeholder="Nome Aluno"
                            onChange={e => setNome(e.target.value)}
                        />
                        <button onClick={salvaChamada} className="button" type="button">Add</button>
                    </form>
                </div>
            </div>
        </div>
    );
}