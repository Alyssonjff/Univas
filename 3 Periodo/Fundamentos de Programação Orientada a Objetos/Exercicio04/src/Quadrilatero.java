public class Quadrilatero {
    private double altura;
    private double largura;

    public Quadrilatero(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public double calcularArea(){
        return this.altura * this.largura;
    }

    public double calcularPerimetro(){
        return (2 * this.altura) + (2 * this.largura);
    }

    public String toString(){
        return String.format("Area: %.2f \nPerimetro: %.2f \nTipo: %s\n", this.calcularArea(), this.calcularPerimetro(), this.altura == this.largura ? "Quadrado" : "Retangulo");
    }
}