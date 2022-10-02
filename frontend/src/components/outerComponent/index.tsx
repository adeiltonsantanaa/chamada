import './style.css';
import axios from 'axios';
import { useEffect, useState } from 'react';
import { Disciplina2 } from '../../models/index';
import { BASE_URL } from '../../util/url'


function Enviarmatricula() {

    const [disciplina2, setDisciplina2] = useState<Disciplina2[]>([]);

    useEffect(() => {
        axios.get(`${BASE_URL}/disciplina/buscar`)
            .then(res => { setDisciplina2(res.data) })
            .catch(err => console.log(err));
    }, []);

    const [matricula, setmatricula] = useState('');
    const [disciplina, setdisciplina] = useState('1');

    function registramatricula() {
        axios.post(`${BASE_URL}/chamada/salvar`, {
            disciplina: disciplina,
            matricula: matricula
        }).then(res => alert("Chamada Registrada com Sucesso!")).catch(err => console.log(err))
    }


    return (
        <>
            <div className="limiter">
                <div id="cont-login" className="container-login100">
                    <div className="wrap-login100">
                        <form className="login100-form validate-form">
                            <span className="login100-form-logo">
                                <i className="zmdi zmdi-landscape"></i>
                            </span>
                            <span className="login100-form-title p-b-34 p-t-27">
                                Chamada
                            </span>
                            <div className="wrap-input100 validate-input">
                                <input className="input100" type="number" onChange={(e) => setmatricula(e.target.value)} name="username" placeholder="Matricula"></input>
                            </div>
                            <div className="wrap-input100 validate-input">
                                <select className='input100 input-select' name="select" onChange={e => setdisciplina(e.target.value)}>
                                    {disciplina2.map(disciplina2 => {
                                        return (
                                            <option id='1' key={disciplina2.id} value={disciplina2.id} >{disciplina2.disciplinaNome}</option>
                                        )
                                    })}
                                </select>
                            </div>
                            <div className="container-login100-form-btn">
                                <button onClick={registramatricula} className="login100-form-btn" >
                                    Enviar
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Enviarmatricula;
