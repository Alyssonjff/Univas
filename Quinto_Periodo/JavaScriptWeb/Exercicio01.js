const nome = 'Alysson';
const idade = 20;
console.log(`nome - ` + nome + ` e idade - ` +idade);

const X = 5; 
const Y = 4;
console.log(X+Y);
console.log(X-Y);
console.log(X*Y);
console.log(X/Y);

const palavra1 = `Ruina`;
const palavra2 = `Perdicao`;
console.log(palavra1+palavra2);

console.log(palavra1.charAt(0));
console.log(palavra1.charAt(palavra1.length-1))

let quantidade = Y 
if(X > Y){
    quantidade = X
} else if(X < Y){
 quantidade = X
}else if( X >= Y){
    quantidade = X
}else if (X <= Y){
    quantidade = X
}
console.log(quantidade);

let Fora = "Fora Escopo";
function testeEscopo(){
    let Dentro = "Dentroo escopo";
    console.log("Dentro da função:");
    console.log(Fora); 
    console.log(Dentro);
}
testeEscopo();
console.log("Fora da função:");
console.log(Fora);

console.log("Mensagem de log.");
console.warn("Mensagem de Aviso.");
console.error("Mensagem de Erro.");
console.info("Mensagemd de Informacao.");

let palavraNumero = "2";
let numero = parseInt(palavraNumero);
console.log("O número inteiro é:", numero);

function Mensagem() {
    console.log("Esta mensagem vai para o console.");
}
Mensagem();

function soma(X, Y){
    return X + Y;
}
const numeroX = 5;
const numeroY = 6;
const result = soma(numeroX,numeroY);
console.log(`Resultado da conta entre `+numeroX +` e `+numeroY + ` foi igual a = ` +result);