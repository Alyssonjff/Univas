package br.edu.univas.Enemies;

public class Wumpus extends Inimigo {
    public Wumpus() {
        super("Wumpus");
    }

    @Override
    public void interagir() {
        System.out.println("Você encontrou o Wumpus! Infelizmente, você perdeu o jogo.");
        // Aqui você pode adicionar a lógica para terminar o jogo ou outras consequências.
    }
}
