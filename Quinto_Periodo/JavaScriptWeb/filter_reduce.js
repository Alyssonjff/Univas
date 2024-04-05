//Escreva uma função que receba um array de números e retorne um novo array apenas com os números pares usando filter.
const numeros = [0, 1, 2, 3, 4, 5, 6];
function numerosPares(arrayDeNumeros){
    return arrayDeNumeros.filter(function(numero){
        return numero % 2 === 0;
    })
}
const numerosPar = numerosPares(numeros);
console.log(numerosPar)
//Crie uma função que receba um array de strings e retorne um novo array apenas com as strings que têm mais de três caracteres usando filter.
const palavras = ["banana", "pera", "laranja", "uva"];
function stringTresPalavras(arrayDePalavras){
    return arrayDePalavras.filter(function(palavra){
        return palavra.length > 3;   
    })
}
const resultadoPalavra = stringTresPalavras(palavras);
console.log(resultadoPalavra)
//Implemente uma função que receba um array de objetos e retorne um novo array apenas com os objetos que têm uma propriedade específica definida, usando filter.
const pessoas = [
    { nome: 'Alysson', idade: 20 },
    { nome: 'Marcos' },
    { nome: 'Anderson', idade: 25 }
  ];
function objetosComPropriedadeDefinida(arrayDeObjetos, propriedade) {
    return arrayDeObjetos.filter(function(objeto) {
      return propriedade in objeto;
    });
}
const pessoasComIdadeDefinida = objetosComPropriedadeDefinida(pessoas, 'idade');
console.log(pessoasComIdadeDefinida); 
//Escreva uma função que receba um array de números e retorne um novo array apenas com os números que são múltiplos de 3 usando filter.
function multiplosDeTres(arrayDeNumeros) {
    return arrayDeNumeros.filter(function(numero) {
      return numero % 3 === 0;
    });
  }
const multiplos = multiplosDeTres(numeros);
console.log(multiplos); 
//Crie uma função que receba uma matriz (array de arrays) e retorne um novo array apenas com as linhas que têm a soma dos elementos maior que 10, usando filter.
const matriz = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
];
function linhasComSomaMaiorQueDez(matriz) {
    return matriz.filter(function (linha) {
        const soma = linha.reduce(function (acumulador, valorAtual) {
            return acumulador + valorAtual;
        }, 0);
        return soma > 10;
    });
}
const linhasFiltradas = linhasComSomaMaiorQueDez(matriz);
console.log(linhasFiltradas); 
//Implemente uma função que receba um array de strings e retorne um novo array apenas com as strings que começam com uma letra maiúscula, usando filter.
function stringsComLetraMaiuscula(arrayDeStrings) {
    return arrayDeStrings.filter(function (string) {
        return /^[A-Z]/.test(string);
    });
}
const stringsFiltradas = stringsComLetraMaiuscula(palavras);
console.log(stringsFiltradas); 
//Escreva uma função que receba um array de números e retorne a soma de todos os elementos usando reduce.
function somaDosElementos(arrayDeNumeros) {
    return arrayDeNumeros.reduce(function (acumulador, numero) {
        return acumulador + numero;
    }, 0);
}
const soma = somaDosElementos(numeros);
console.log(soma);
//Crie uma função que receba um array de strings e retorne uma única string concatenando todos os elementos usando reduce.
function concatenarStrings(arrayDeStrings) {
    return arrayDeStrings.reduce(function (acumulador, string) {
        return acumulador + string;
    }, '');
}
const resultado = concatenarStrings(palavras);
console.log(resultado); 
//Implemente uma função que receba um array de objetos e retorne a soma de uma propriedade específica de todos os objetos usando reduce.
function somaPropriedade(arrayDeObjetos, propriedade) {
    return arrayDeObjetos.reduce(function (acumulador, objeto) {
        if (objeto.hasOwnProperty(propriedade)) {
            acumulador += objeto[propriedade];
        }
        return acumulador;
    }, 0);
}
const nome = somaPropriedade(produtos, 'nome');
console.log(nome); 
//Escreva uma função que receba um array de números e retorne o produto de todos os elementos usando reduce.
function produtoDosElementos(arrayDeNumeros) {
    return arrayDeNumeros.reduce(function(acumulador, numero) {
      return acumulador * numero;
    }, 1); 
}
const produto = produtoDosElementos(numeros);
console.log(produto); 
//Crie uma função que receba uma matriz (array de arrays) e retorne um único valor com a soma de todos os elementos da matriz, usando reduce.
function somaMatriz(matriz) {
    return matriz.reduce(function(acumuladorExterno, linha) {
      return acumuladorExterno + linha.reduce(function(acumuladorInterno, elemento) {
        return acumuladorInterno + elemento;
      }, 0);
    }, 0);
}
const somaM = somaMatriz(matriz);
console.log(somaM);
//Implemente uma função que receba um array de números e retorne o maior número usando reduce.
function encontrarMaiorNumero(arrayDeNumeros) {
    if (arrayDeNumeros.length === 0) {
      return undefined;
    }
    return arrayDeNumeros.reduce(function(maior, numero) {
      return numero > maior ? numero : maior;
    });
}
const maiorNumero = encontrarMaiorNumero(numeros);
console.log(maiorNumero); 
  