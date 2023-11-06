package geradornf;

public class NotaFiscal {
    private double valor;
    private double imposto;

    public NotaFiscal(double valor) {
        this.setValor(valor);
    }

    public NotaFiscal(double valor, double imposto) {
        this.setValor(valor);
        this.setImposto(imposto);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
}