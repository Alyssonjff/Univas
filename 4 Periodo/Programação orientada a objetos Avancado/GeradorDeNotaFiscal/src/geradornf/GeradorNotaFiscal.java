package geradornf;

import java.util.List;

public class GeradorNotaFiscal {
    private List<AcaoAposGerarNotaFiscal> acoes;

    public GeradorNotaFiscal(List<AcaoAposGerarNotaFiscal> acoes) {
        this.acoes = acoes;
    }

    public NotaFiscal gera(Fatura fatura) {
        double valor = fatura.getValorMensal();

        NotaFiscal nf = new NotaFiscal(valor, getImpostoSimples(valor));

        for (AcaoAposGerarNotaFiscal acao : acoes) {
            acao.executar(nf);
        }


        return nf;
    }

    private double getImpostoSimples(double valor) {
        return valor * 0.6;
    }
}