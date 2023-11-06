package services;

import models.Funcionario;

public class CalculadoraSalario {
    public double calculaSalario(Funcionario funcionario) {
        return funcionario.getCargo().getRegraCalculo().calcular(funcionario);
    }
}