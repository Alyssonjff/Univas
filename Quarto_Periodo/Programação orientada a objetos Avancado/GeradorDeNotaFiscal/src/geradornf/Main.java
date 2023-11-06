package geradornf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<AcaoAposGerarNotaFiscal> acoes = new LinkedList<AcaoAposGerarNotaFiscal>();
        acoes.add(new EnviadorEmail());
        acoes.add(new NotaFiscalDao());

        EnviadorEmail email = new EnviadorEmail();
        NotaFiscalDao dao = new NotaFiscalDao();
        Fatura fatura = new Fatura();
        GeradorNotaFiscal geradorNF = new GeradorNotaFiscal(acoes);
        geradorNF.gera(fatura);
    }
}