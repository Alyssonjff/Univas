package br.edu.univas.Enemies;

public abstract class Inimigo {
    protected String nome;
    protected boolean ativo;

    public Inimigo(String nome) {
        this.nome = nome;
        this.ativo = true;
    }

    public abstract void interagir();
}
