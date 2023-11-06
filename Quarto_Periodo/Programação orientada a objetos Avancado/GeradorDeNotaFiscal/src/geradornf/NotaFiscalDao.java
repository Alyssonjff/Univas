package geradornf;

public class NotaFiscalDao implements AcaoAposGerarNotaFiscal{

    public void persiste(NotaFiscal nf) {
        System.out.println("A NF foi persistida no banco de dados!");
    }

    @Override
    public void executar(NotaFiscal nf) {

    }
}