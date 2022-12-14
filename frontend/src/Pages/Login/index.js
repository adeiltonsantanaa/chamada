import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './styles.css';
import { Link } from 'react-router-dom';
import api from '../../services/api';
import cadeado from '../../assets/cadeado.svg'
import { saudacao } from '../../uteis/getSaudacao';
import { FiArrowLeft } from "react-icons/fi";


export default function Login() {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const history = useNavigate();

    async function login(e) {
        e.preventDefault();
        const data = {
            email,
            password,
        };
        try {
            const response = await api.post('usuario/autenticacao', data);
            localStorage.setItem('email', email);
            localStorage.setItem('accessToken', response.data.token);
            history('/chamadas')
        } catch (err) {
            alert("Login ou Senha incorreto, tente novamente!");
        }

    };

    return (
        <div className='login-container'>
            <section className='form'>
                <div>
                    <form onSubmit={login}>
                        <h1>{saudacao()} professor.</h1>
                        <input
                            placeholder='Username'
                            value={email}
                            onChange={e => setEmail(e.target.value)}
                        />
                        <input
                            type="password"
                            placeholder='Password'
                            value={password}
                            onChange={e => setPassword(e.target.value)}
                        />
                        <button className='button' type="submit">Login</button>
                    </form>
                    <Link className="back-link-aluno" to='/'>
                        <FiArrowLeft size={16} color='#251fc5' />
                        Sou Aluno
                    </Link>
                </div>

            </section>
            <img src={cadeado} alt="login" />
        </div>
    )
}