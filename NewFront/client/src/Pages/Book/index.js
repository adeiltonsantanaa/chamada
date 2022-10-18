import React, {useEffect} from "react";
import {Link} from 'react-router-dom';
import axios from "axios";
import {FiPower, FiEdit, FiTrash2} from 'react-icons/fi'
import './styles.css';

import api from '../../services/api';


export default function Book() {


    useEffect(() => {
        const token = localStorage.getItem('accessToken');
        console.log(token)
        axios.get('http://localhost:8080/api/v1/chamada/buscar/chamadas', {headers: {Authorization: 'Bearer ' + token}}).then(res => console.log(res)).catch(err => console.log(err));
    })

    function teste(e) {
        e.preventeDefault();
        
    }

    return(
        <div className="book-container">
            <header>
                <span>Welcome <strong>Adeilton</strong></span>
                <Link className="button" to='/book/new'>Add new Book</Link>
                <button type="button" onClick={teste}>
                    <FiPower size={18} color='#25ifc5'/>
                </button>
            </header>

            <h1>Registered books</h1>
            <ul>
                <li>
                    <strong>Title:</strong>
                    <p>Docker</p>
                    <strong>Author:</strong>
                    <p>Nigel</p>
                    <strong>Price:</strong>
                    <p>R$ 47,90</p>
                    <strong>Date:</strong>
                    <p>17/10/2022</p>

                    <button type="button">
                        <FiEdit size={20} color='#25ifc5'/>
                    </button>
                    <button type="button">
                        <FiTrash2 size={20} color='#25ifc5'/>
                    </button>
                </li>
                <li>
                    <strong>Title:</strong>
                    <p>Docker</p>
                    <strong>Author:</strong>
                    <p>Nigel</p>
                    <strong>Price:</strong>
                    <p>R$ 47,90</p>
                    <strong>Date:</strong>
                    <p>17/10/2022</p>

                    <button type="button">
                        <FiEdit size={20} color='#25ifc5'/>
                    </button>
                    <button type="button">
                        <FiTrash2 size={20} color='#25ifc5'/>
                    </button>
                </li>
                <li>
                    <strong>Title:</strong>
                    <p>Docker</p>
                    <strong>Author:</strong>
                    <p>Nigel</p>
                    <strong>Price:</strong>
                    <p>R$ 47,90</p>
                    <strong>Date:</strong>
                    <p>17/10/2022</p>

                    <button type="button">
                        <FiEdit size={20} color='#25ifc5'/>
                    </button>
                    <button type="button">
                        <FiTrash2 size={20} color='#25ifc5'/>
                    </button>
                </li>
                <li>
                    <strong>Title:</strong>
                    <p>Docker</p>
                    <strong>Author:</strong>
                    <p>Nigel</p>
                    <strong>Price:</strong>
                    <p>R$ 47,90</p>
                    <strong>Date:</strong>
                    <p>17/10/2022</p>

                    <button type="button">
                        <FiEdit size={20} color='#25ifc5'/>
                    </button>
                    <button type="button">
                        <FiTrash2 size={20} color='#25ifc5'/>
                    </button>
                </li>
            </ul>
        </div>
    );
}