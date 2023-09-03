package main;

import models.Cargos;
import models.Funcionario;
import services.CalculadoraSalario;

public class Principal {
    public static void main(String[] args) {
        Funcionario Anderson = new Funcionario(Cargos.DESENVOLVEDOR, 3000.00);
        Funcionario Alysson = new Funcionario(Cargos.DESENVOLVEDOR, 7000.00);

        System.out.println(new CalculadoraSalario().calculaSalario(Anderson));
        System.out.println(new CalculadoraSalario().calculaSalario(Alysson));
    }
}