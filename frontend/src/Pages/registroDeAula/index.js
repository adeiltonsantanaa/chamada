import React, { useState } from "react";
import { Link } from 'react-router-dom';
import { FiArrowLeft } from "react-icons/fi";
import api from "../../services/api";

import './styles.css';

export default function RegistroAula() {

    const [turma, setTurma] = useState([]);

    const [discModel, setDiscModel] = useState(1);
    const [dataRegistro, setDataRegistro] = useState(new Date());
    const [professor, setProfessor] = useState(1);
    const [descricao, setDescricao] = useState('');

    useState(() => {
        api.get('/api/v1/chamada/buscar/turmas')
            .then(res => setTurma(res.data))
            .catch(err => console.log(err));
    }, [])

    console.log(turma)
    function salvaChamada() {
        const token = localStorage.getItem('accessToken');
        api.post('/api/v1/registro', {
            descricao: descricao,
            professor: professor,
            discModel: discModel,
            dataRegistro: dataRegistro
        }, { headers: { Authorization: 'Bearer ' + token } }).then(res => alert("Presença Registrada!"))
            .catch(err => console.log(err))
    }

    return (
        <div className="new-chamada-container">
            <div className="content">
                <section className="form">
                    <h1>Registrar Aula</h1>
                    <Link className="back-link" to='/chamadas'>
                        <FiArrowLeft size={16} color='#251fc5' />
                        Chamadas
                    </Link>
                </section>
                <div>
                    <p className="paragrafo">Entre com o Registro de Aula</p>
                    <form>
                        <input
                            placeholder="Descrição da Aula"
                            value={descricao}
                            onChange={e => setDescricao(e.target.value)}
                        />
                        <input
                            placeholder="Professor"
                            value={professor}
                            onChange={e => setProfessor(e.target.value)}
                        />
                        <input
                            placeholder="Data"
                            type={"date"}
                            value={dataRegistro}
                            onChange={e => setDataRegistro(e.target.value)}
                        />
                        <select onChange={e => setDiscModel(e.target.value)}>
                            {turma.map(turma => {
                                return <option key={turma.id} value={turma.id}>{turma.disciplinaNome}</option>
                            })}
                        </select>
                        <button onClick={salvaChamada} className="button" type="button">Registrar</button>
                    </form>
                </div>
            </div>
        </div>
    );
}