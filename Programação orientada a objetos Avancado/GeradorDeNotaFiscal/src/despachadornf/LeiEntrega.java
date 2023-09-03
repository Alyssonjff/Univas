package despachadornf;

import geradornf.NotaFiscal;

public class LeiEntrega {
    public boolean deveEntregarUrgente(NotaFiscal nf) {
        return nf.getValor() >= 100000;
    }
}