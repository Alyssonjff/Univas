package geradornf;

public class EnviadorEmail implements AcaoAposGerarNotaFiscal {

    public void executar(NotaFiscal nf) {
        System.out.println("Email com a NF foi enviado!");
    }
}