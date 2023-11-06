package despachadornf;

import geradornf.NotaFiscal;

public class CalculadorImposto {
    public double calcular(NotaFiscal nf){
        return nf.getValor() * 0.6;
    }
}