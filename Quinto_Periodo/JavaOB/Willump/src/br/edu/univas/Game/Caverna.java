package br.edu.univas.Game;
import java.util.Map;
import java.util.EnumMap;
import br.edu.univas.Enemies.Inimigo;

public class Caverna {
    private Map<Direcao, Caverna> conexoes;
    private Inimigo inimigo;

    public Caverna() {
        conexoes = new EnumMap<>(Direcao.class);
        inimigo = null;
    }

    public void conectar(Direcao direcao, Caverna caverna) {
        conexoes.put(direcao, caverna);
    }

    // Getters e setters omitidos para brevidade
}
