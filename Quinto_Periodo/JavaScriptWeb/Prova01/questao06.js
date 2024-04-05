const pessoa = [
    {
        nome: "Alysson",
        nascimento: 20,
        cpf: "111.111.111-11"
    },
    {
        nome: "Anderson",
        nascimento: 25,
        cpf: "222.222.222-22"
    }
]
const alunos = [
    {
        nome: "Alysson",
        nascimento: 20,
        cpf: "111.111.111-11",
        matricula: 123,
        notas: [4,5,2,8]
    },
    {
        nome: "Anderson",
        nascimento: 25,
        cpf: "222.222.222-22",
        matricula: 456,
        notas: [6,7,4,10]
    }
]

function calcularMedias(alunos){
    
    alunos.forEach(alunos => {
        alunos.media = 0
        alunos.notas.forEach(nota => {
            alunos.media += nota
        })
        alunos.media /= alunos.notas.length
    
    })
    
    return {
        alunos
    }
}

console.log(calcularMedias(alunos))