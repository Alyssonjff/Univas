package despachadornf;

import geradornf.NotaFiscal;
import geradornf.NotaFiscalDao;

public class DespachadorNotasFiscais {
    private NotaFiscalDao dao;
    private CalculadorImposto impostos;
    private LeiEntrega lei;
    private Correios correios;

    public NotaFiscalDao getDao() {
        return dao;
    }

    public void setDao(NotaFiscalDao dao) {
        this.dao = dao;
    }

    public CalculadorImposto getImpostos() {
        return impostos;
    }

    public void setImpostos(CalculadorImposto impostos) {
        this.impostos = impostos;
    }

    public LeiEntrega getLei() {
        return lei;
    }

    public void setLei(LeiEntrega lei) {
        this.lei = lei;
    }

    public Correios getCorreios() {
        return correios;
    }

    public void setCorreios(Correios correios) {
        this.correios = correios;
    }

    public DespachadorNotasFiscais(NotaFiscalDao dao, CalculadorImposto impostos, LeiEntrega lei, Correios correios) {
        super();
        this.dao = dao;
        this.impostos = impostos;
        this.lei = lei;
        this.correios = correios;
    }

    public void processa(NotaFiscal nf) {
        double imposto = impostos.calcular(nf);
        nf.setImposto(imposto);

        if (lei.deveEntregarUrgente(nf)) {
            correios.enviaPorSedex10(nf);
        } else {
            correios.enviaPorSedexComum(nf);
        }

        dao.persiste(nf);
    }
}