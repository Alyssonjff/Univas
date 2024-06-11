package br.edu.univas.Enemies;

public class Poco extends Inimigo {
    public Poco() {
        super("Poço sem fundo");
    }

    @Override
    public void interagir() {
        System.out.println("Você caiu em um poço sem fundo! Infelizmente, você perdeu o jogo.");
        // Aqui você pode adicionar a lógica para terminar o jogo ou outras consequências.
    }
}

