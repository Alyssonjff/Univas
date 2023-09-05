package br.poo.geradorestatisticasbr;

public class EstatisticaGolsChutes{
	private int golsTimeVisitante;
	private int golsTimeMandante;
	private int chutesAGolTimeVisitante;
	private int chutesAGolTimeMandante;
	
	public int getGolsTimeVisitante() {
		return golsTimeVisitante;
	}
	
	public int getGolsTimeMandante() {
		return golsTimeMandante;
	}
	
	public int getChutesAGolTimeVisitante() {
		return chutesAGolTimeVisitante;
	}
	
	public int getChutesAGolTimeMandante() {
		return chutesAGolTimeMandante;
	}
	
	public int getTotalGols() {
		return golsTimeMandante + golsTimeVisitante;
	}

	public EstatisticaGolsChutes(int golsTimeVisitante, int golsTimeMandante, int chutesAGolTimeVisitante,
			int chutesAGolTimeMandante) {
		super();
		this.golsTimeVisitante = golsTimeVisitante;
		this.golsTimeMandante = golsTimeMandante;
		this.chutesAGolTimeVisitante = chutesAGolTimeVisitante;
		this.chutesAGolTimeMandante = chutesAGolTimeMandante;
	}
	
	public String imprimir() {
		return "Total de gols no jogo: " + getTotalGols()  + System.lineSeparator() +
			"O time mandante fez " + this.getGolsTimeMandante() + " gols" + System.lineSeparator() +
			"O time visitante fez " + this.getGolsTimeVisitante() + " gols" + System.lineSeparator() +
			"O time mandante chutou " + this.getChutesAGolTimeMandante() + " vezes no gol" + System.lineSeparator() +
			"O time visitante chutou " + this.getChutesAGolTimeVisitante() + " vezes no gol" + System.lineSeparator();
	}
}
