package br.poo.geradorestatisticasbr;

public class Main {

	public static void main(String[] args) {
		Jogo jogo = new Jogo(2, 4, 21, 30, 10, 22, 18, 20, 70, 96, 32, 1, 0, 24, 1, 1);
		GeradorEstatisticasFaltasCartoes gerador = new GeradorEstatisticasFaltasCartoes();
		EstatisticaFaltasCartoes faltasCartoes = gerador.calcularFaltasCartoes(jogo);
		GeradorEstatisticaTempoJogo teste = new GeradorEstatisticaTempoJogo(jogo);
		EstatisticaTempoJogo tempoJogo = teste.calcularTemposJogo(jogo);
		GeradorEstatisticaGolsChutes teste2 = new GeradorEstatisticaGolsChutes(jogo);
		EstatisticaGolsChutes chutesGol = teste2.calcularChutesGol(jogo);

		System.out.println(tempoJogo.imprimir());
		System.out.println(chutesGol.imprimir());
		System.out.println(faltasCartoes.imprimir());
	}

}