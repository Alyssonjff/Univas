package br.poo.geradorestatisticasbr;
public class GeradorEstatisticaGolsChutes {
    public GeradorEstatisticaGolsChutes(Jogo jogo) {
    }
    public EstatisticaGolsChutes calcularChutesGol(Jogo jogo) {
        return new EstatisticaGolsChutes(jogo.getGolsTimeVisitante(),
                jogo.getGolsTimeMandante(),
                jogo.getChutesAGolTimeVisitante(),
                jogo.getChutesAGolTimeMandante()
        );
    }
}