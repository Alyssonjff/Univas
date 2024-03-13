// Demonstre por meio de código como funciona o conceito de função call-back

function tempo(palavra){
 console.log(palavra)

}
function callback (funcao){
    tempo(funcao)
}
tempo("Chave")

callback("Mestre")