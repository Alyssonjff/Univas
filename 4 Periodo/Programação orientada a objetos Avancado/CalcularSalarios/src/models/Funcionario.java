package models;

public class Funcionario {
    private Cargos cargo;
    private double salario;

    public Funcionario(Cargos cargo, double salario) {
        this.cargo = cargo;
        this.salario = salario;
    }

    public double getSalario() {
        return this.salario;
    }
    public Cargos getCargo() {
        return this.cargo;
    }
}