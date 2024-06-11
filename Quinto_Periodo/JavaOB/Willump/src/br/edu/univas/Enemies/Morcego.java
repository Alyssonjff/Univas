package br.edu.univas.Enemies;
import br.edu.univas.Game.Caverna;
import java.util.List;
import java.util.Random;

public class Morcego extends Inimigo {
    private List<Caverna> todasCavernas;

    public Morcego(List<Caverna> todasCavernas) {
        super("Morcego");
        this.todasCavernas = todasCavernas;
    }

    @Override
    public void interagir() {
        System.out.println("Um morcego te pegou e te levou para outra caverna!");
        Caverna novaCaverna = escolherCavernaAleatoria();
        // Aqui você pode adicionar a lógica para mover o jogador para a nova caverna
        // Por exemplo: jogador.setCavernaAtual(novaCaverna);
    }

    private Caverna escolherCavernaAleatoria() {
        Random random = new Random();
        return todasCavernas.get(random.nextInt(todasCavernas.size()));
    }
}