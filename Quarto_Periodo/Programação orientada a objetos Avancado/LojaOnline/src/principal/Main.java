package principal;

import models.Produto;
import services.CalcularFrete;
public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Calça", 0.4, "Médio");
        Produto produto2 = new Produto("Gorro", 0.1, "Pequeno");

        CalcularFrete calculadoraFrete = new CalcularFrete();

        double custoFrete1 = calculadoraFrete.calcularFrete(produto1);
        double custoFrete2 = calculadoraFrete.calcularFrete(produto2);

        System.out.println("Custo de frete para " + produto1.getNome() + ": R$" + custoFrete1);
        System.out.println("Custo de frete para " + produto2.getNome() + ": R$" + custoFrete2);
    }
}