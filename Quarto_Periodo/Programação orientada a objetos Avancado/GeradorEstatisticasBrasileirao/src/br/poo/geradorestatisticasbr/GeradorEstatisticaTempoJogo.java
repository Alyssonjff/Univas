package br.poo.geradorestatisticasbr;

public class GeradorEstatisticaTempoJogo {

    public GeradorEstatisticaTempoJogo(Jogo jogo) {
    }

    public EstatisticaTempoJogo calcularTemposJogo(Jogo jogo) {
        return new EstatisticaTempoJogo(
                jogo.getPosseBolaTimeVisitanteDefesaEmMin(),
                jogo.getPosseBolaTimeVisitanteAtaqueEmMin(),
                jogo.getPosseBolaTimeMandanteDefesaEmMin(),
                jogo.getPosseBolaTimeMandanteAtaqueEmMin(),
                jogo.getTempoTotalBolaRolandoEmMin(),
                jogo.getTempoTotalJogoEmMin()
        );
    }
}