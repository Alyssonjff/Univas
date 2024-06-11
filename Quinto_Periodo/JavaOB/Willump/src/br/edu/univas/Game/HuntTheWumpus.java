package br.edu.univas.Game;
import java.util.List;
import java.util.ArrayList;
import br.edu.univas.Enemies.*;

public class HuntTheWumpus {
    private List<Caverna> cavernas;
    private Caverna cavernaAtual;
    private int flechas;
    private boolean jogoAtivo;

    public HuntTheWumpus() {
        cavernas = new ArrayList<>();
        jogoAtivo = true;
        flechas = 3; // O jogador começa com 3 flechas
    }

    public void iniciarJogo() {
        // Configurar o labirinto e posicionar os elementos
        // ...
    }

    public void jogarRodada(Direcao direcao) {
        // Lógica para mover o jogador e interagir com a caverna
        // ...
    }

    public void verificarEstado() {
        // Verificar se o jogador ganhou ou perdeu
        // ...
    }

    public static void main(String[] args) {
        HuntTheWumpus jogo = new HuntTheWumpus();
        jogo.iniciarJogo();

        while (jogo.jogoAtivo) {
            Output.mostrarMensagem("Escolha uma direção (LESTE, OESTE, NORTE, SUL):");
            String escolha = Input.lerEntradaDoUsuario();
            Direcao direcao;
            try {
                direcao = Direcao.valueOf(escolha.toUpperCase());
                jogo.jogarRodada(direcao);
                jogo.verificarEstado();
            } catch (IllegalArgumentException e) {
                Output.mostrarMensagem("Direção inválida. Tente novamente.");
            }
        }
    }
}
