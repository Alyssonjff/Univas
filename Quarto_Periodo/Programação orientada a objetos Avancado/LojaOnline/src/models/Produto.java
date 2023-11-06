package models;

public class Produto {
    private String nome;
    private double peso;
    private String tamanho;

    public Produto(String nome, double peso, String tamanho) {
        this.nome = nome;
        this.peso = peso;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public String getTamanho() {
        return tamanho;
    }
}