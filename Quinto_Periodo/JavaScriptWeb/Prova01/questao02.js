//Crie uma função que ao ser executada deve escrever na tela uma mensagem recebida por parametro após 5 segundos

let palavra = "Alysson"
function tempo(palavra1){
    chave = setTimeout(palavra1,5)
    return chave
}
rua = tempo(palavra)
console.log(rua)