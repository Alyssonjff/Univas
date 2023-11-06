let listaTarefas = document.getElementById('listaTarefas');
let input1 = document.getElementById('input1');

function addTarefa(){
    const texto = input1.value;
    let novoElemento = document.createElement("li");
    novoElemento.innerHTML = texto;
    listaTarefas.appendChild(novoElemento);
    input1.value = "";
}