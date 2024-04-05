//1. Crie uma funcão que recebe como parâmetro um conjunto de elementos e imprima eles em ordem crescente.
function crescente(algo) {
    algo.sort(function(a, b) {
        return a - b;
    });
    console.log("Elementos em ordem crescente:");
    for (let i = 0; i < algo.length; i++) {
        console.log(algo[i]);
    }
}
const numeroCrescente = [5, 2, 9, 1, 7];
crescente(numeroCrescente);
console.log("")


//2. Crie uma função que recebe como parâmetro um conjunto de elementos e um elemento específico, a função deve retornar a posição da primeira ocorrência do elemento no array. Caso não exista deve retornar -1.
function firstOC(X, elemento) {
    const posicao = X.indexOf(elemento);
    if (posicao !== -1) {
        console.log(`A primeira ocorrência de "${elemento}" está na posição ${posicao}.`);
    } else {
        console.log(`O elemento "${elemento}" não foi encontrado no array.`);
    }

    return posicao; 
}
const numeroOcorrencia = [20,40,60,90,80,30];
const search = 30;
firstOC(numeroOcorrencia, search);
console.log("")

//3. Crie uma função que recebe dois arrays como parâmetro e retorne um array com os elementos de ambos arrays.
function concatArray(array1, array2) {
    let resultado = [];
    resultado = resultado.concat(array1);
    resultado = resultado.concat(array2);
    return resultado;
}
let array1 = [1, 2, 3];
let array2 = [4, 5, 6];
let resultado = concatArray(array1, array2);
console.log(resultado);
//4. Implemente a funcionalidade do método reverse.
function meuReverse(agnt) {
    const resultado = [];
    for (let i = agnt.length - 1; i >= 0; i--) {
        resultado.push(agnt[i]); 
    }
    return resultado;
}
const correto = [1, 2, 3, 4, 5];
const invertido = meuReverse(correto);
console.log("Array original:", correto);
console.log("Array invertido:", invertido);
console.log("")


//5. Implemente a funcionalidade do método keys. Ou seja, crie uma função que recebe como parâmetro um objeto e retorna um array com as proprieades do objeto.
function keys(objeto) {
    let chaves = [];
    for (let chave in objeto) {
        if (objeto.hasOwnProperty(chave)) {
            chaves.push(chave);
        }
    }
    return chaves;
}
let pessoa = {
    nome: 'Alysson',
    idade: 20,
    cidade: 'Pouso Alegre'
};

let propriedades = keys(pessoa);
console.log(propriedades);
console.log("")


//6. Crie uma função que recebe um array e retorne um array com os números pares. Valide se cada elemento corresponde a um número.
function numerosPares(array) {
    let pares = [];
    for (let i = 0; i < array.length; i++) {
        if (typeof array[i] === 'number' && array[i] % 2 === 0) {
            pares.push(array[i]);
        }
    }
    return pares;
}
let array = [1, 2, 3, 4, '5', 6, '7', 8];
let pares = numerosPares(array);
console.log(pares);
console.log("")


//7. Crie uma função que recebe um array e um caracter delimitador. A função deve juntar todos elementos do array em uma string e separar os elementos pelo delimitador.
function juntarComDelimitador(array, delimitador) {
    let resultado = array.join(delimitador);
    return resultado;
}
let arraia = ['a', 'b', 'c', 'd'];
let delimitador = '-';
let result = juntarComDelimitador(array, delimitador);
console.log(resultado);
console.log("")


//8. Crie uma funcão que recebe um array de objetos que possuem o modelo abaixo. A função deve calcular a média de notas geral, a maior média e a menor média, estes dados devem ser retornados em um objeto.
//{
//nome: "fulano",
//notas: [4,5,2,8]
//}
function calcularEstatisticasNotas(alunos) {
    let somaTotal = 0;
    let maiorMedia = -Infinity;
    let menorMedia = Infinity;
    alunos.forEach(aluno => {
        const somaNotas = aluno.notas.reduce((acc, nota) => acc + nota, 0);
        const media = somaNotas / aluno.notas.length;
        somaTotal += media;
        if (media > maiorMedia) {
            maiorMedia = media;
        }
        if (media < menorMedia) {
            menorMedia = media;
        }
    });
    const mediaGeral = somaTotal / alunos.length;
    return {
        mediaGeral,
        maiorMedia,
        menorMedia
    };
}
let alunos = [
    { nome: "Fulano", notas: [4, 5, 2, 8] },
    { nome: "Alysson", notas: [6, 7, 8, 9] },
    { nome: "Anderson", notas: [3, 6, 7, 8] }
];

let estatisticas = calcularEstatisticasNotas(alunos);
console.log(estatisticas);
console.log("")


//9. Crie uma função que recebe um conjunto de elementos e um número como parâmetros. A função deve retornar um novo conjunto com vários conjuntos menores de elementos contendo cada um a quantidade de elementos igual ao valor passado como parametro.
//elementos = [1,2,3,4,5,6,7,8]
//calcular(elementos, 2)
//[[1,2], [3,4], [5,6], [7,8]]
function dividirConjunto(elementos, tamanho) {
    let conjuntos = [];
    for (let i = 0; i < elementos.length; i += tamanho) {
        conjuntos.push(elementos.slice(i, i + tamanho));
    }
    return conjuntos;
}
let elementos = [1, 2, 3, 4, 5, 6, 7, 8];
let tamanho = 2;
let subconjuntos = dividirConjunto(elementos, tamanho);
console.log(subconjuntos);
console.log("")

//10. Crie uma função que recebe um conjunto de objetos e uma string que será o nome de uma propriedade. A função deve retornar um conjunto de objetos apenas com aqueles que possuem a propriedade passada como parametro definida.
function filtrarPorPropriedade(objetos, propriedade) {
    let objetosFiltrados = objetos.filter(objeto => objeto.hasOwnProperty(propriedade));
    return objetosFiltrados;
}
let conjuntoDeObjetos = [
    { nome: 'Fulano', idade: 30 },
    { nome: 'Alysson', sexo: 'masculino' },
    { nome: 'Anderson', idade: 25, cidade: 'São Paulo' },
    { nome: 'Silvio', idade: 40, profissao: 'engenheiro' }
];
let propriedade = 'idade';
let objetosFiltrados = filtrarPorPropriedade(conjuntoDeObjetos, propriedade);
console.log(objetosFiltrados);