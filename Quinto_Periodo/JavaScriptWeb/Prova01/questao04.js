//Demonstre por meio de codigo a diferença de contexto entre as funções de expressão e as arrows functions



let objetoQualquer = {
    propriedade1: "chave 1",
    propriedade2: "chave 2",
    //normalFunction
    juntaPropriedades: function(){
        return this.propriedade1 + " - " + this.propriedade2
    },

    //arrowFunction
    juntaPropriedadesQueNaoFunciona: () => {
        return this.propriedade1 + " - " + this.propriedade2
    }
}