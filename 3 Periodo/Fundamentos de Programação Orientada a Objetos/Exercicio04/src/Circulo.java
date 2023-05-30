public class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double CalcularA(){
        return (Math.PI* Math.pow(raio,2));
    }

    public double CalcularP(){
        return (2 * Math.PI) * raio;
    }


    public String toString (){
        return String.format("Area: %.2f \nPerimetro: %.2f \nRaio: %.2f \n" , this.CalcularA(), this.CalcularP(), this.raio);
    }
}