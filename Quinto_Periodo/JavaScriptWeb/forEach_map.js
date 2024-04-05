/*1. Exercícios para forEach:
• Fácil:
1. Escreva um código que use o método forEach para imprimir todos os elementos de um array de números.
*/
const numeros = [1, 2, 3, 4, 5, 6];
numeros.forEach(function(numero){
    console.log(numero);
})
/*
2. Crie uma função que receba um array de strings e use forEach para imprimir cada string em maiúsculas.
*/
const palavras = ["testando1", "testando2", "testando3", "testando4"];
palavras.forEach(function(palavra){
    console.log(palavra.toUpperCase());
})
/*
1. Escreva um programa que use forEach para iterar sobre um array de objetos e imprima o valor de uma propriedade específica de cada objeto.
*/
const pessoas = [
    {nome: "Alysson", idade:20},
    {nome: "Marcos", idade:27},
    {nome: "Anderson", idade:25}
];
pessoas.forEach(function(pessoa){
    console.log(pessoa.nome);
})
/*
2. Crie uma função que receba um array de números e use forEach para calcular e imprimir a soma de todos os elementos.
*/
let soma = 0;
numeros.forEach(function(numero){
    soma += numero;
})
console.log(soma)
/*
1. Implemente uma função que receba uma matriz (array de arrays) e use forEach para calcular e imprimir a soma de cada linha da matriz.
*/
const matriz = [
    [5, 2, 3],
    [4, 1, 6],
    [7, 8, 1]
];
function calcularSomaDasLinhas(dados){
    dados.forEach(function(linha) {
        let somaLinha = 0;
        linha.forEach(function(dados) {
            somaLinha += dados;
        });
        console.log("A soma da linha é:", somaLinha);
    });
}
calcularSomaDasLinhas(matriz);
/*
2. Escreva um programa que use forEach para iterar sobre um array de arrays de números e encontre o maior número em cada subarray, imprimindo-o.
*/
matriz.forEach(function(subarray){
    let maiorNumero = subarray[0];
    subarray.forEach(function(matriz){
        if(matriz > maiorNumero){
            maiorNumero = matriz;
        }
    })
    console.log("O maior número no subarray é:", maiorNumero);
});

/*
• Fácil:
1. Escreva uma função que receba um array de números e retorne um novo array com cada número multiplicado por 2 usando map.
*/
const numerosMultiplicacao = multiplicarPorDois(numeros);
function multiplicarPorDois(arrayNumeros){
    return arrayNumeros.map(function(numero){
        return numero * 2;
    });
}
console.log(numerosMultiplicacao);
/*
2. Crie uma função que receba um array de palavras e retorne um novo array com cada palavra em maiúsculas usando map.
*/
const palavrasMaiusculas = transformarPalavras(palavras);
function transformarPalavras(arrayPalavras){
    return arrayPalavras.map(function(palavra){
        return palavra.toUpperCase();
    })
}
console.log(palavrasMaiusculas);
/*
1. Implemente uma função que receba um array de objetos e retorne um novo array apenas com os valores de uma propriedade específica de cada objeto, usando map.
*/
function extrairPropriedadeNome(arrayDeObjetos, propriedade){
    return arrayDeObjetos.map(function(objeto){
        return objeto[propriedade];
    })
}

const nomes = extrairPropriedadeNome(pessoas, "nome");
console.log(nomes);
const idades = extrairPropriedadeNome(pessoas, "idade");
console.log(idades);
/*
2. Escreva uma função que receba um array de strings e retorne um novo array com o comprimento de cada string usando map.
*/
const tamanhoDasPalavras = transformarPalavras(palavras);
function transformarPalavras(arrayPalavras){
    return arrayPalavras.map(function(palavra){
        return palavra.length;
    })
}
console.log(tamanhoDasPalavras);
/*
1. Crie uma função que receba uma matriz (array de arrays) e retorne um novo array com a soma de cada linha da matriz, usando map.
*/
function somarLinhasMatriz(matriz) {
    return matriz.map(function(linha) {
      return linha.reduce(function(acumulador, valorAtual) {
        return acumulador + valorAtual;
      }, 0);
    });
  }
  const somas = somarLinhasMatriz(matriz);
  console.log(somas); 
/*
2. Implemente uma função que receba um array de números e retorne um novo array com a raiz quadrada de cada número, arredondada para o inteiro mais próximo, usando map..
*/
function raizQuadradaArredondada(arrayDeNumeros) {
    return arrayDeNumeros.map(function(numero) {
      return Math.round(Math.sqrt(numero));
    });
  }

const raizesQuadradas = raizQuadradaArredondada(numeros);

console.log(raizesQuadradas);