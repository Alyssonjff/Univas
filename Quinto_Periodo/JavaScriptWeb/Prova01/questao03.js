//Cria uma função que receba N parametros e os imprima linha por linha em tela

let quantidade = []
quantidade.push(1)
quantidade.push(2)
quantidade.push(3)
quantidade.push(4)
function imprimir(qntd){
    for(let i = 0;i < qntd.length;i++){
        console.log(qntd[i])
    }
}
imprimir(quantidade)