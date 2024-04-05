/*
Exercícios para join:

Fácil:

Escreva uma função que receba um array de strings e retorne uma única string com todas as strings separadas por um 
espaço usando join.
*/
const palavras = [["Alysson"],["Marcos"],["Anderson"]]
const arrayDePalavrasEspacado = palavras.join(" ")
console.log(arrayDePalavrasEspacado)
/*
Crie uma função que receba um array de palavras e retorne uma única string com todas as palavras separadas por uma 
vírgula usando join.
*/
const arrayDePalavrasVirgula = palavras.join(",")
console.log(arrayDePalavrasVirgula)
/*
Intermediário:

Implemente uma função que receba um array de números e retorne uma única string com todos os números separados
por um hífen usando join.
*/
let numeros = [[1],[2],[3]]
let numerosComHifen = numeros.join("-")
console.log(numerosComHifen)
/*
Escreva uma função que receba um array de datas e retorne uma única string com todas as datas
formatadas como "DD/MM/YYYY", separadas por um ponto e vírgula, usando join.
*/
let data = [["19/11/2003"],["28/12/2023"],["28/01/1988"]]
let dataComPV = data.join(";")
console.log(dataComPV)
/*
Difícil:

Crie uma função que receba uma matriz (array de arrays) e retorne uma única string com todos os elementos da 
matriz separados por um ponto e vírgula, usando join.
*/
const arrayArray = [[1],[2],[5]]
function concatenar(matriz){
    var arraysConvertidos = matriz.map(function(array){
        return array.join(",")
    })
    var resultado = arraysConvertidos.join(";")
    return resultado
}
console.log(concatenar(arrayArray))
/*
Implemente uma função que receba um array de strings e retorne uma única string com todas as strings em maiúsculas,
 separadas por um espaço, usando join.
*/
const PalavrasGrandes = palavras.join(" ").toUpperCase()
console.log(PalavrasGrandes)
