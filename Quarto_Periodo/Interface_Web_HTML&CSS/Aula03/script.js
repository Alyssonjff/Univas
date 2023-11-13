let listaTarefas = document.getElementById('listaTarefas');
let input1 = document.getElementById('input1');

function addTarefa(){
    const texto = input1.value;
    let novoElemento = document.createElement("li");
    novoElemento.innerHTML = `<p>${texto}</p>
                                <button onclick='excluirTarefa(this)'>Excluir</button>
                                <button onclick='concluirTarefa(this)'>Concluir</button>
                                <button onclick='editarTarefa(this)'>Editar</button>`;
    listaTarefas.appendChild(novoElemento);
    input1.value = "";
}

function excluirTarefa(button) {
    alert("Item Excluido");
    listaTarefas.removeChild(button.parentElement);
}

function concluirTarefa(button) {
    alert("Item Concluido");
    listaTarefas(button.parentElement).style.color = "#16f216";
}

function editarTarefa(button) {
    alert("Coloque o valor desejado na area de adicionar e pressioner editar");
        const texto = input1.value;
    let novoElemento = document.innerHTML = `<p>${texto}</p>`;
    listaTarefas.appendChild(novoElemento);
    input1.value = "";
}