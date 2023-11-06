package regrascalculos;

import interfaces.RegraCalculo;
import models.Funcionario;

public class Regra15ou25DescSalario2000 implements RegraCalculo {


    public double calcular(Funcionario funcionario) {
        return funcionario.getSalario() > 2000 ? funcionario.getSalario() * 0.75 : funcionario.getSalario() * 0.85;
    }
}