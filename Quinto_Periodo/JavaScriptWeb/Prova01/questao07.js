function calcularMedias(alunos){
    let mediaGeral = 0
    let maiorMedia = null
    let menorMedia = null
    alunos.forEach(aluno => {
        alunos.media = 0
        alunos.notas.forEach(nota => {
            alunos.media += nota
        })
        alunos.media /= alunos.notas.length

        mediaGeral += alunos.media

        if(menorMedia == null){
            menorMedia = alunos.media
        }else{
            if(alunos.media < menorMedia){
                menorMedia = alunos.media
            }
        }

        if(maiorMedia == null){
            maiorMedia = alunos.media
        }else{
            if(alunos.media > maiorMedia){
                maiorMedia = alunos.media
            }
        }
    })
    mediaGeral /= alunos.length

    return {
        "mediaGeral" : mediaGeral, 
        "menorMedia" : menorMedia, 
        "maiorMedia" : maiorMedia
    }
}