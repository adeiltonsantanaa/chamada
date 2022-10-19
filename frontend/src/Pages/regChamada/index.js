import React, { useState } from "react";
import { Link } from 'react-router-dom';
import { FiArrowLeft } from "react-icons/fi";
import api from "../../services/api";
import './styles.css'

export default function RegistroChamadaAluno() {

    const [turma, setTurma] = useState([]);
    const [disciplina, setDisciplina] = useState(1);
    const [matricula, setMatricula] = useState(0);

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


    return (
        <div className="new-chamada-container">
            <div className="content">
                <section className="form">
                    <h1>Adicionar Nova Chamada</h1>
                    <Link className="back-link" to='/login'>
                        <FiArrowLeft size={16} color='#251fc5' />
                        Sou Professor
                    </Link>
                </section>
                <div>
                    <p className="paragrafo">Entre com a informação da chamada</p>
                    <form>
                        <input
                            placeholder="Matricula"
                            value={matricula}
                            onChange={e => setMatricula(e.target.value)}
                        />
                        <select onChange={e => setDisciplina(e.target.value)}>
                            {turma.map(turma => {
                                return <option key={turma.id} value={turma.id}>{turma.disciplinaNome}</option>
                            })}
                        </select>
                        <button onClick={salvaChamada} className="button" type="button">Add</button>
                    </form>
                </div>
            </div>
        </div>
    );
}