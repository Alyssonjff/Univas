package br.poo.geradorestatisticasbr;

public class GeradorEstatisticasFaltasCartoes {

    public EstatisticaFaltasCartoes calcularFaltasCartoes(Jogo jogo) {
        return new EstatisticaFaltasCartoes(
                jogo.getCartoesAmarelosVisitante(),
                jogo.getCartoesVermelhosVisitante(),
                jogo.getCartoesAmarelosMandante(),
                jogo.getCartoesVermelhosMandante(),
                jogo.getFaltasTimeVisitante(),
                jogo.getFaltasTimeMandante()
        );
    }
}
