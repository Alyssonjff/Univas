let listaTarefas = document.getElementById('listaTarefas');
let quest = document.getElementById('quest');


function addTarefas(){
    const texto = quest.value;
    let novoElemento = document.createElement('li');
    novoElemento.innerHTML = `<p>${texto}</p> 
        <button onclick='excluirTarefa(this)' style='display:inline'>Excluir</button> 
        <button onclick='concluir(this)' style='display:inline'>Concluir</button>
        <button onclick='editar(this)' style='display:inline'>Editar</button>`;
    listaTarefas.appendChild(novoElemento);
    quest.value = '';
}

function excluirTarefa(button){
    listaTarefas.removeChild(button.parentElement);
}

function concluir(button){questquest
    const tarefa = button.parentElement;
    const paragrafo = tarefa.querySelector('p');
    paragrafo.style.color = 'green';
    button.disabled = true;
}

function editar(button) {
    const quest = button.parentElement;
    const paragrafo = quest.querySelector('p');
    const textoAtual = paragrafo.textContent;

    const new_input = document.createElement('input');
    new_input.value = textoAtual;

    const save_button = document.createElement('button');
    save_button.textContent = 'Salvar';

    save_button.onclick = function() {
        paragrafo.textContent = new_input.value;

        quest.removeChild(new_input);
        quest.removeChild(save_button);

        paragrafo.style.display = 'inline';

        const botoes = quest.querySelectorAll('button');
        botoes.forEach(botao => {
            botao.style.display = 'inline';
        });
    };

    const botoes = quest.querySelectorAll('button');
    botoes.forEach(botao => {
        botao.style.display = 'none';
    });

    paragrafo.style.display = 'none';
    quest.appendChild(new_input);
    quest.appendChild(save_button);
}