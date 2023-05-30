public class Triangulo {
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(double ladoA, double ladoB, double ladoC) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }
    public double calculaA(){
        double p = (this.ladoA + this.ladoB + this.ladoC) / 2;
        return Math.sqrt(p * (p - this.ladoA) * (p - this.ladoB) * (p - this.ladoC));
    }

    public double calculaPerim(){
        return this.ladoA + this.ladoB + this.ladoC;
    }

    public String obterClassificacao(){
        if (this.ladoA == this.ladoB
                && this.ladoA == this.ladoC){
            return "Equilatero";
        } else {
            return (this.ladoA != this.ladoB
                    && this.ladoA != this.ladoC
                    && this.ladoB != this.ladoC) ?
                    "Escaleno" :
                    "Isosceles";
        }
    }
    public String toString(){
        return String.format("Area: %.2f \nPerimetro: %.2f \nClassificacao: %s\n", this.calculaA(), this.calculaPerim(), this.obterClassificacao());
    }
}