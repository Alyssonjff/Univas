package Exercicio03;

import java.util.Random;
import java.util.ArrayList;

public class ContaCorrente {
    private String titular;
    private double saldo;
    private String cpf;
    private String cartao;
    private String senha;
    private double cheque_especial;
    private double limite_cartao;
    private int numero;
    private String[] chave_pix;
    private String agencia;
    private double juros_cheque = 0.2;
    private ArrayList<String> extrato;
    private double valorEmJuizo;

    public ContaCorrente(String titular, String cpf, String senha) {
        this.titular = titular;
        this.cpf = cpf;
        this.senha = senha;
        this.saldo = 0;
        this.cheque_especial = 0;
        this.limite_cartao = 0;
        this.agencia = "1234";
        this.numero = (1234567);
        this.extrato = new ArrayList<String>();
        this.valorEmJuizo = 0;
    }
    public double getSaldo(){
        return  this.saldo;
    }
    public void depositar(double valor){
        if (this.valorEmJuizo > 0) {
            valor -= this.valorEmJuizo;
            this.valorEmJuizo = 0;
        }
        if (this.saldo < 0) {
            valor += this.saldo * (this.juros_cheque);
            this.cheque_especial += (valor - (this.saldo * -1));
        }
        this.saldo += valor;
        this.extrato.add("Depósito: +" + valor);
    }
    public void sacar(double valor){
        if (this.saldo + this.cheque_especial >= valor) {
            if (this.saldo < valor) {
                this.cheque_especial -= (valor - this.saldo);
            }
            this.saldo -= valor;
            this.extrato.add("Saque: -" + valor);
        } else {
            System.out.println("Não é possível sacar.");
        }
    }
    public void transferir(String agencia, int conta, double valor ){
        this.sacar(valor);
        this.extrato.add("Transferência para conta " + agencia + "/" + conta + ": -" + valor);
    }
    public void transferirPix(String pix, double valor ){
        this.sacar(valor);
        this.extrato.add("Transferência via Pix para " + pix + ": -" + valor);
    }

    public double getLimitChequeEspecialTotal() {
        if (this.saldo < 0) {
            return this.cheque_especial + (-1 * this.saldo);
        } else {
            return this.cheque_especial;
        }
    }
    public double getLimiteChequeEspecialAtual() {
        return this.cheque_especial;
    }
    public String getTitular() {
        return this.titular + " [" + this.cpf + "]";
    }
    public String toString() {
        String retorno = "Titular: " + this.getTitular() + "\n";
        retorno += "Ag: " + this.agencia + " Cc: " + this.numero + "\n";
        retorno += "Saldo atual: " + this.getSaldo();

        return retorno;
    }
    public ArrayList<String> getExtrato() {
        return this.extrato;
    }
    public void setValorEmJuizo(double valorEmJuizo) {
        this.valorEmJuizo = valorEmJuizo;
    }
}