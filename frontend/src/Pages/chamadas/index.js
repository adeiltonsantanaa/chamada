import React, { useEffect, useState } from "react";
import { Link, useNavigate } from 'react-router-dom';
import { FiPower } from 'react-icons/fi'
import './styles.css';
import api from "../../services/api";

export default function Chamadas() {

    const [chamada, setChamada] = useState([]);
    const history = useNavigate();

    useEffect(() => {
        const token = localStorage.getItem('accessToken');
        api.get('/api/v1/chamada/buscar/chamadas', { headers: { Authorization: 'Bearer ' + token } })
            .then(res => setChamada(res.data))
            .catch(err => alert(err.response.data.message));
    }, [])

    function logout() {
        localStorage.clear();
        history('/login')
    }

    return (
        <div className="chamada-container">
            <header>
                <span>Bem vindo, <strong>{localStorage.getItem('email')}</strong></span>
                <Link className="button" to='/chamadas/manual'>Chamada Manual</Link>
                <Link className="button button-reg" to='/chamadas/registrar/aula'>Registrar Aula</Link>
                <Link className="button button-reg" to='/chamadas/adicionar/aluno'>Add alunos</Link>
                <button type="button" onClick={logout}>
                    <FiPower size={18} color='#25ifc5' />
                </button>
            </header>
            <h1>Lista de Chamadas</h1>
            <ul>
                {chamada.map(chamada => (
                    <li key={chamada.id}>
                        <strong>Id:</strong>
                        <p>{chamada.id}</p>
                        <strong>Matricula:</strong>
                        <p>{chamada.matricula}</p>
                        <strong>Nome Turma:</strong>
                        <p>{chamada.discModel.turmaNome}</p>
                        <strong>Nome Disciplina:</strong>
                        <p>{chamada.discModel.disciplinaNome}</p>
                        <strong>Data Registro:</strong>
                        <p>{chamada.datetime}</p>
                        <strong>Nome Professor:</strong>
                        <p>Lucas Martins</p>
                    </li>
                ))}
            </ul>
        </div>
    );
}