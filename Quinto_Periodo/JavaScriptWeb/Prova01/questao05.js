//Demonstre por meio de código a diferença entre let e const

// Uma variável let é de escopo local e podem ser reatribuidas
let texto = "Alysson"
console.log(texto)
texto = "Anderson"
console.log(texto)

// const também é uma variavel local e não pode ser reatribuida
const texto2 = "Silvio"
console.log(texto2)
//texto2 = "Jean"
//console.log(texto2) - isso vai quebrar o código