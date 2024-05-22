import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

const App = () => {
  const [advice, setAdvice] = useState('');

  const conselhoAleatorio = async () => {
    try {
      const response = await axios.get('https://api.adviceslip.com/advice');
      setAdvice(response.data.slip.advice);
    } catch (error) {
      console.error(`Conselho Não encontrado, erro pela busca da palavra:  "${keyword}" erro:`, error);
    }
  };

  const conselhosPorPalavraPreDefinida = async (keyword) => {
    try {
      const response = await axios.get(`https://api.adviceslip.com/advice/search/${keyword}`);
      setAdvice(response.data.slips[0].advice);
    } catch (error) {
      console.error(`Conselho Não encontrado, erro pela busca da palavra:  "${keyword}" erro:`, error);
      alert("Tente outra palavra")
    }
  };

  return (
    <div className="container mt-5">
      <h1>Gerador de conselhos</h1>
      <p>{advice}</p>
      <div className="d-grid gap-2" role="group" aria-label="Advice buttons">
        <button className="btn btn-outline-primary" onClick={() => conselhosPorPalavraPreDefinida('dog')}>
          Dog
        </button>
        <button className="btn btn-outline-primary" onClick={() => conselhosPorPalavraPreDefinida('cat')}>
          Cat
        </button>
        <button className="btn btn-primary " onClick={() => conselhosPorPalavraPreDefinida('study')}>
          Study
        </button>
        <button className="btn btn-success" onClick={conselhoAleatorio}>
          Aleatorio
        </button>
      </div>
    </div>
  );
};

export default App;