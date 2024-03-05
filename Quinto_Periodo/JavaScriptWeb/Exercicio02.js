//Crie uma função chamada saudacao que aceite um nome como parâmetro e retorne uma saudação personalizada.
function saudacao(nome) {
    return `Olá, ${nome}! Você é você.`;
}
const nomeUsuario = "Alysson";
console.log(saudacao(nomeUsuario)); 

//Crie uma função chamada somaQuadrado que aceite dois números como parâmetros e retorne a soma dos números e o quadrado dessa soma.
function somaQuadrado(num1, num2){
    let soma = num1 + num2;
    let quadrado = soma * soma;
    return `A adição deles é ${soma} e o quadrado dessa soma é ${quadrado}.`;
}
const num1 = 20 , num2 = 15;

console.log(somaQuadrado(num1, num2));

//Crie uma função chamada concatenaPalavras que aceite duas strings como parâmetros e retorne a concatenação delas.
function concatenaPalavras(chave1, chave2){
    let concat = chave1 + chave2;
    return `A concatenação das palavras é ${concat}`;
}
const chave1 = "Alysson";
const chave2 = "Ferreira";
console.log(concatenaPalavras(chave1, chave2));

//Crie uma função chamada primeiroUltimoCaractere que aceite uma string como parâmetro e retorne uma string contendo o primeiro e o último caractere.
function primeiroUltimoCaractere(word){
    const primeiro = word.charAt(0);
    const ultimo = word.charAt(word.length - 1);
    return `Primeiro caractere : ${primeiro} , ultimo caractere : ${ultimo}`;
}

const carac = "Ferreira";
console.log(primeiroUltimoCaractere(carac));

//Crie uma função chamada comparacaoNumeros que aceite dois números como parâmetros e retorne uma mensagem indicando qual é maior.
function comparacaoNumeros(num1, num2){
    let comparacao;
    if(num1 > num2){
       comparacao = num1; 
    }else{
        comparacao = num2;
    }
    return `O número maior é ${comparacao}`;
}
console.log(comparacaoNumeros(num1, num2));

//Crie uma função que declare uma variável dentro dela e outra fora. Tente acessar essas variáveis dentro e fora da função, observando o escopo.
const mensagemEscopoArquivo = "Testando asdfg";

function escreverMensagemNoTerminal(mensagemEscopoFuncao){
    const mensagemEscopoFuncao = "Testando zxcvb";
    console.log(mensagemEscopoFuncao)
}

escreverMensagemNoTerminal("ok!")
console.log(mensagemEscopoArquivo) 

//Crie uma função chamada calcularMedia que aceite um array de números como parâmetro e retorne a média.
function calcularMedia(numeros) {
    const soma = numeros.reduce((total, numero) => total + numero, 0);
    const media = soma / numeros.length;
    return media;
}
const meuArray = [10, 20, 30, 40, 50];
const mediaCalculada = calcularMedia(meuArray);
console.log(`A média dos números é: ${mediaCalculada}`);

//Crie uma função chamada fatorial que aceite um número como parâmetro e retorne o fatorial desse número.
function fatorial(num) {
    if (num < 0) {
        return "Indefinido";
    } else if (num === 0) {
        return 1;
    } else {
        let resultado = 1;
        for (let i = 1; i <= num; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
const numero = 2;
console.log(`Fatorial de ${numero} é: ${fatorial(numero)}`);

//Crie uma função chamada executaCallback que aceite outra função como parâmetro e a execute.
function executaCallback(callback) {

    callback();
}
function minhaFuncao() {
    console.log("Teste");
}
executaCallback(minhaFuncao);

//Crie uma função chamada somaDinamica que possa receber um número variável de argumentos e retorne a soma deles.
async function aguardarSegundos(segundos) {
    await new Promise(resolve => setTimeout(resolve, segundos * 1000));
    console.log(`Passou-se ${segundos} secs!`);
}
const tempoEspera = 3; 
aguardarSegundos(tempoEspera);

//Crie uma função que utilize uma arrow function para imprimir o valor de this em diferentes contextos.
//Validação de Números:

//Crie uma função chamada ehNumero que aceite um parâmetro e retorne verdadeiro se for um número e falso caso contrário.
function ehNumero(valor) {
    return typeof valor === "number" && !isNaN(valor);
}
console.log(ehNumero(2));
console.log(ehNumero("Olá"));
console.log(ehNumero(3.14));
console.log(ehNumero("553"));
