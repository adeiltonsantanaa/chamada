import React, { useState } from "react";
import { Link } from 'react-router-dom';
import { FiArrowLeft } from "react-icons/fi";
import api from "../../services/api";

import './styles.css';

export default function RegistroAula() {

    const [turma, setTurma] = useState([]);
    const [disciplina, setDisciplina] = useState(1);
    const [matricula, setMatricula] = useState();
    const [data, setData] = useState(Date.now());
    const [professor, setProfessor] = useState('');

    useState(() => {
        api.get('/api/v1/chamada/buscar/turmas')
            .then(res => setTurma(res.data))
            .catch(err => console.log(err));
    }, [])

    function salvaChamada() {
            api.post('/api/v1/chamada/salvar', {
                disciplina: disciplina,
                matricula: matricula,
            }).then(res => alert("Presença Registrada!"))
            .catch(err => alert(err.response.data.message))
    }

    function teste(e) {
        e.preventDefault()
        console.log(data)
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
                            value={matricula}
                            onChange={e => setMatricula(e.target.value)}
                        />
                        <input
                            placeholder="Professor"
                            value={professor}
                            onChange={e => setMatricula(e.target.value)}
                        />
                        <input
                            placeholder="Data"
                            type={"date"}
                            value={data}
                            onChange={e => setData(e.target.value)}
                        />
                        <select onChange={e => setDisciplina(e.target.value)}>
                            {turma.map(turma => {
                                return <option key={turma.id} value={turma.id}>{turma.disciplinaNome}</option>
                            })}
                        </select>
                        <button onClick={teste} className="button" type="button">Registrar</button>
                    </form>
                </div>
            </div>
        </div>
    );
}